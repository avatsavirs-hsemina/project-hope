from nltk import tokenize
import re
from vaderSentiment.vaderSentiment import SentimentIntensityAnalyzer 
import pandas

def sentiment_scores(sentence): 

	sid_obj = SentimentIntensityAnalyzer()  
	sentiment_dict = sid_obj.polarity_scores(sentence) 
	
	if sentiment_dict['compound'] >= 0.05 : 
		print("Positive") 

	elif sentiment_dict['compound'] <= - 0.05 : 
		print("Negative") 

	else : 
		print("Neutral") 

def senti_scores(paragraph):

	analyzer = SentimentIntensityAnalyzer()
	sentence_list = tokenize.sent_tokenize(paragraph)
	paragraphSentiments = 0.0
	for sentence in sentence_list:
		sentiment_dict = analyzer.polarity_scores(sentence)
		paragraphSentiments += sentiment_dict["compound"]
		average_sentiment = round(paragraphSentiments / len(sentence_list), 4)
		
	if average_sentiment >= 0.05 : 
		print("Positive") 

	elif average_sentiment <= - 0.05 : 
		print("Negative") 

	else : 
		print("Neutral") 


def cleanhtml(raw_html):
  cleanr = re.compile('<.*?>')
  cleantext = re.sub(cleanr, '', raw_html)
  return cleantext
 
if __name__ == "__main__" : 
	

	df = pandas.read_excel('~/Untitled.xlsx')
	values = df['DESCRIPTION'].values

	for value in values:
		senti_scores(cleanhtml(value))
	
	