function test(){
	for(var i = 0; i < e.childElementCount; i++){
	    if(e.getElementsByTagName('option')[i].selected){
	      ary[num] = i;
	      num++;
	    }
	    }
};