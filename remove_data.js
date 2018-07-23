var db=new Sdb('localhost',11810)
//定义删除0524-0614日期区间的数据
var removeDates = new Array();
for(var i=24;i<32;i++){
	var date = '201705'+i+'';
	removeDates.push(date);
}
for(var i=1;i<15;i++){
	var date = '201706';
	if(i>9){
		date=date+i+'';
	}else{
		 date=date+'0'+i;
	 }
   removeDates.push(date);
 }
 //循环调用sequoiadb的dropCL命令
 for(var i=0;i<removeDates.length;i++){
	try{
	 db.MySpace.dropCL('MyLogData_'+removeDates[i]);
	}catch(e){
		println(e);
	}  
 } 