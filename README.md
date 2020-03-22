# jpa_many_to_many_mapping
This  is a sample project for Spring data jpa many to many mapping

Here there are two entities as Book and Author. One Book can have many Authors , One Author can have many Books.Here I have considered Book
as the parent entity and Author as the child entity. Among Book and Author there is a many to many relationship.
Here I have mapped this relationship as a bidirectional relationship. For testing these relationsip I have added below mappings inside a rest controller called TestResource.

1.Save data -> @GetMapping("/save") 2.Retrieve data -> @GetMapping("/retrieve") 3.Update data -> @GetMapping("/update") 4.Delete data -> @GetMapping("/delete")
