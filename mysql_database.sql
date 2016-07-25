CREATE DATABASE poster;
CREATE TABLE api_box (
  id int(11) NOT NULL AUTO_INCREMENT,
  bundle_name varchar(45) NOT NULL,
  bundle_description varchar(45) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY bundle_name_UNIQUE (bundle_name)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

INSERT INTO api_box (id,bundle_name,bundle_description) VALUES (1,'Paneer','Delicious Paneer items');
INSERT INTO api_box (id,bundle_name,bundle_description) VALUES (2,'Chicken','Mouth watering chicken recipes');
INSERT INTO api_box (id,bundle_name,bundle_description) VALUES (3,'Eggs','Sunday ho ya monday roz khayen ande');


CREATE TABLE api_document (
  id int(11) NOT NULL AUTO_INCREMENT,
  document_name varchar(45) NOT NULL,
  document_description varchar(45) NOT NULL,
  document_content longtext,
  api_box_id int(11) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY document_name_UNIQUE (document_name)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


INSERT INTO api_document (id,document_name,document_description,document_content,api_box_id) VALUES (1,'Kadahi Paneer','Khao to jano','<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<documentation>
    <section>
        <id>1</id>
        <name>INGREDIENTS </name>
        <detail>&lt;ul&gt;
	&lt;li&gt;250 gms paneer/cottage cheese, cubed&lt;/li&gt;
	&lt;li&gt;5-6 medium tomatoes/tamatar, chopped&lt;/li&gt;
	&lt;li&gt;1 or 2 green chilies/hari mirch, chopped&lt;/li&gt;
	&lt;li&gt;6-7 garlic/lahsun, crushed&lt;/li&gt;
	&lt;li&gt;1.5 inch ginger/adrak, half crushed and half julienned&lt;/li&gt;
	&lt;li&gt;2 green bell peppers/capsicum/shimla mirch, julienned&lt;/li&gt;
	&lt;li&gt;5-6 kashmiri red chilies&lt;/li&gt;
	&lt;li&gt;1.5 tbsp coriander seeds/dhania seeds, roasted&lt;/li&gt;
	&lt;li&gt;1.5 to 2 tsp crushed kasuri methi/dry fenugreek leaves&lt;/li&gt;
	&lt;li&gt;&amp;frac12; tsp garam masala powder&lt;/li&gt;
	&lt;li&gt;&amp;frac12; cup chopped coriander/cilantro leaves/dhania&lt;/li&gt;
	&lt;li&gt;2 tbsp&lt;/li&gt;
	&lt;li&gt;salt or black salt&lt;/li&gt;
&lt;/ul&gt;
</detail>
        <order>2</order>
    </section>
    <section>
        <id>2</id>
        <name>Pics</name>
        <detail>&lt;p&gt;&lt;img alt="" src="http://vegrec.vegrecipesofindi.netdna-cdn.com/wp-content/uploads/2011/10/kadhai-paneer-recipe.jpg" style="height:853px; width:640px" /&gt;&lt;/p&gt;
</detail>
        <order>1</order>
    </section>
</documentation>
',1);
INSERT INTO api_document (id,document_name,document_description,document_content,api_box_id) VALUES (2,'Sahi Paneer','Lajawab shahi paneer',NULL,1);


