# osu-data-reader
a tool which can easy read osu!.db,collection.db,scores.db to a structured data

## How to use?
```kotlin
//get osu!.db file data
val data = OsuDataReader.getOsuData("your osu.db file path")

//get scores.db file data
val scores = OsuDataReader.getScoresList("your scores.db file path")

//get collection.db file data
val collection = OsuDataReader.getOsuCollectionList("your collection.db file path")


```
