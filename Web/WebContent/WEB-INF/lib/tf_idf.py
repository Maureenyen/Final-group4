# -*- coding: utf-8 -*-
import jieba
from jieba import analyse

jieba.case_sensitive = True
jieba.set_dictionary("./lib/jieba/dict2.txt")

def tf_idf(articles):

    tags = analyse.extract_tags(articles,topK=5, withWeight = False)
    mod_tags =[]
    for term in tags:
        mod_tags.append(term.decode('unicode_escape'))
    return(mod_tags)
