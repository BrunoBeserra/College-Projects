#############################################
# Student Name: Bruno do Nascimento Beserra
# Student ID: 300392300
#############################################

import pymongo
import pprint

#Connect to the local MongoDB server
client = pymongo.MongoClient()

# Create/use the university database.
db = client["university"]

# Create/use the instructors collection.
col = db["instructors"]

# Delete the exising documents.
result_info = col.delete_many({})

doclist = [
   {
      "name":"Wong",
      "dept_name":"CS",
      "salary":68000,
      "teach":[
         {
            "course_id":"CS-101",
            "year":2024
         },
         {
            "course_id":"CS-347",
            "year":2024
         }
      ]
   },
   {
      "name":"Levy",
      "dept_name":"CS",
      "salary":80000,
      "teach":[
         {
            "course_id":"CS-128",
            "year":2022
         },
         {
            "course_id":"CS-201",
            "year":2023
         },
         {
            "course_id":"CS-201",
            "year":2024
         }
      ]
   },
   {
      "name":"Brandt",
      "dept_name":"Finance",
      "salary":95000,
      "teach":[
         {
            "course_id":"FIN-201",
            "year":2022
         },
         {
            "course_id":"FIN-301",
            "year":2023
         },
         {
            "course_id":"FIN-320",
            "year":2023
         },
         {
            "course_id":"FIN-320",
            "year":2024
         }
      ]
   },
   {
      "name":"Davis",
      "dept_name":"Finance",
      "salary":78000,
      "teach":[
         {
            "course_id":"FIN-102",
            "year":2023
         },
         {
            "course_id":"FIN-200",
            "year":2024
         }
      ]
   },
   {
      "name":"Crick",
      "dept_name":"Biology",
      "salary":92000,
      "teach":[
         {
            "course_id":"BIO-101",
            "year":2023
         },
         {
            "course_id":"BIO-301",
            "year":2023
         },
         {
            "course_id":"BIO-301",
            "year":2024
         }
      ]
   },
   {
      "name":"Tyler",
      "dept_name":"Biology",
      "salary":72000,
      "teach":[
         {
            "course_id":"BIO-101",
            "year":2022
         },
         {
            "course_id":"BIO-201",
            "year":2023
         },
         {
            "course_id":"BIO-101",
            "year":2024
         },
         {
            "course_id":"BIO-201",
            "year":2024
         }
      ]
   }
]

result_info = col.insert_many(doclist)

# Assignment Query
result = col.aggregate([
   {"$unwind": "$teach"},
   { "$group": {"_id": {"year": "$teach.year", "dept_name": "$dept_name"},
     "num_instructor": { "$addToSet": "$name"}
   }},
   {"$project": {
       "_id": 0,
       "year": "$_id.year",
       "dept_name": "$_id.dept_name",
       "num_instructor": {"$size": "$num_instructor"},
   }},
   {"$sort": {"year": -1, "dept_name": 1}}
])

for doc in result:
   print(doc)
   
# Close the connection.
client.close()
