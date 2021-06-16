# -*- coding:utf-8 -*-
# @Time : 2021-06-16 19:59
# @Author : Clivia
# @File : segmentation.py
# @Software : PyCharm
# 导入扩展库
import jieba  # 结巴分词
import sys


def segment(str):
    # 文本分词
    seg_list = jieba.cut_for_search(str)  # 精确模式分词
    result_list = []
    remove_words = []
    # with open('F:\\x-learning-system\\x-learning-system\\back-end\\src\\main\\resources\\baidu_stopwords.txt', 'r', encoding='utf-8') as f:
    #     for line in f:
    #         remove_words.extend(list(line.strip('\n').split(',')))  # 自定义去除词库
    # with open('F:\\x-learning-system\\x-learning-system\\back-end\\src\\main\\resources\\hit_stopwords.txt', 'r', encoding='utf-8') as f:
    #     for line in f:
    #         remove_words.extend(list(line.strip('\n').split(',')))  # 自定义去除词库
    for word in seg_list:  # 循环读出每个分词
        if word not in remove_words and word != " " and word != "\n" and word != "":  # 如果不在去除词库中
            print(word + " ")
    #         result_list.append(word)  # 分词追加到列表
    # return result_list

if __name__ == '__main__':
    segment(sys.argv[1])