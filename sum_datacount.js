var db = new Sdb('localhost', 11810)
var cursor = db.listCollections();
while (cursor.next()) {
     var obj = cursor.current().toObj();
     var realName = obj['Name'];
     var indexOf = realName.indexOf(".");
     var space = realName.substring(0, indexOf);
     var cl = realName.substring(indexOf + 1);
     var count = db.getCS(space).getCL(cl).count();
     println(obj['Name'] + ",count:" + count);
 }