# -*- coding:utf-8 -*-
import csv
import requests
from bs4 import BeautifulSoup
import urllib.request
import time
import re
import pandas as pd
import xlrd

#爬取原数据各个类别的title,url等
def gettitle(url,leng):
    data = []
    for i in range(1,leng):
        print('正在爬取第',i,'页的数据')
        req = urllib.request.Request(url.format(i))
        req.add_header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.36 Safari/537.36")
        response = urllib.request.urlopen(req)
        html = response.read()
        html = html.decode('utf-8')
        soup=BeautifulSoup(html,features="html.parser")
        ul=soup.find('ul',attrs={'class':'list_14 p1_2 clearfix'})
        lis=ul.find_all('li')
        for li in lis:
            a=li.find('a')
            lianjie = a.attrs['href']
            title = li.text
            info=[title,'http://jhsjk.people.cn/'+lianjie]
            data.append(info)
        return data

#爬取原文,并保存
def getcontent(data,name):
    dfdata = pd.DataFrame(data)
    url=list(dfdata[1])
    for i in range(0,len(url)):
        req = urllib.request.Request(url[i])
        req.add_header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.36 Safari/537.36")
        response = urllib.request.urlopen(req)
        html = response.read()
        html = html.decode('utf-8')
        soup = BeautifulSoup(html, features="html.parser")
        div = soup.find('div',attrs={'class':'d2txt clearfix'})
        text=div.text
        data[i].append(text)
    title=['title','url','content']
    dfdata = pd.DataFrame(data,columns=title)
    dfdata.to_excel('E:/PycharmProject/driver/学习系统数据/{}'.format(name))

if __name__ == '__main__':
    # 每个类别对应的url,增加对应url即可
    urls = ['http://jhsjk.people.cn/result/{}?area=401', 'http://jhsjk.people.cn/result/{}?area=402',
            "http://jhsjk.people.cn/result/{}", "http://jhsjk.people.cn/result/{}?type=108"]
    # 每个类别的页面
    lens = [18, 10, 71, 11]
    # 类别名称
    names = ['国内最新讲话.xlsx', '国外最新讲话.xlsx', '原文.xlsx', "外交.xlsx"]
    for i in range(0,len(urls)):
        data=gettitle(urls[i],lens[i])
        getcontent(data,names[i])