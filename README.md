Simulation of a distributed NoSQL database.

Commands:

 - CREATEDB <Db_Name> <No_Nodes> <Max_Capacity>
  
 - CREATE <Entity> <RF> <No_Attributes>
    Attribute_1 Type_1
    Attribute_2 Type_2
    ….
    Attribute_n Type_n
  
 - INSERT <ENTITY> <Val_Attr1> <Val_Attr2> ... <Val_Attrn>
  
 - DELETE <ENTITY> <Primary_Key>
  
 - UPDATE <ENTITY> <Primary_Key> <Attr1> <New_Val_Attr1> ... <Attrn> <New_Val_Attrn>
  
 - GET <ENTITY> <Primary_Key>, with a result looking like:
    <Node_1> <Node_2>...<Node_n> <Attr1>:<Val_Attr1> ... <Attrn>:<Val_Attrn>
      
 - SNAPSHOTDB
 
 - CLEANUP <DB_NAME> <TIMESTAMP(ns)>
