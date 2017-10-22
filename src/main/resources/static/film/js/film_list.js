/**
 * Created by gaowenfeng on 2017/10/22.
 */
getLanguageList();
var size=5;
var startPage=0;

function getLanguageList() {
    getData('/language',{
        page:1,
        size:999
    },function (result) {
        var str = '';
        var list = result.data.list;
        for(var i=0;i<list.length;i++){
            str+='<li><a onclick="changeSelect(\'language\','+list[i].languageId+',\''+list[i].name+'\')" href="#">'+list[i].name+'</a></li>'
        }
     //   console.log(str)
        $('#dropdown-menu_language').html(str);
        search(1);
    })
}


function changeSelect(doc,id,name) {
    $('#'+doc).html(name+'<strong class="caret"></strong>');
    $('#'+doc).attr("name",id);
 //   alert($('#'+doc).attr("name"));
}

function search(page) {
    // console.log("l:",$('#language').attr("name"));
    // console.log("r:",$('#releaseYear').attr("name"));
    // console.log("t:",$('#title').val());
    // console.log("c:",$('#category').val());
    var data={
        page:page,
        size:size,
        category:$('#category').val(),
        title:$('#title').val()
    }
    if($('#language').attr("name")!="language")
        data.languageId=$('#language').attr("name")
    if($('#releaseYear').attr("name")!="releaseYear")
        data.releaseYear=$('#releaseYear').attr("name")
    getFilmList('/film',data)
}

function getFilmListByActor(id,page) {
    var url = '/film/actor/'+id;
    var data={
        page:page,
        size:size,
        id:id
    }
    getFilmList(url,data)
}
function getFilmList(url,data){
    getData(url,data,function (result) {
        // console.log(result.data);
        var str = ''
        var list = result.data.list;
        for(var i=0;i<list.length;i++){
            var category = ''
            var categoryList = list[i].categoryList;
            var actorList = list[i].actorList;
            // console.log(categoryList.length)

            for(var j=0;j<categoryList.length;j++){
                if(j<categoryList.length-1)
                    category+=categoryList[j].name+',';
                else
                    category+=categoryList[j].name;
            }
            str+='<div class="jumbotron well-sm">'+
                '<h2>'+list[i].title+ '</h2>'+
                '<p><span class="label label-success" data-toggle="tooltip" title="语种" >'+list[i].language+'</span>&nbsp;'+
                '<span data-toggle="tooltip" title="发行年份" class="label label-info">'+list[i].releaseYear+'</span>&nbsp;'+
                '<span data-toggle="tooltip" title="分类" class="label label-warning">'+category+'</span></p>'+
                '<p>'+list[i].description+'</p><p>';
            for(var k=0;k<actorList.length;k++){
                str+='<a  href="javascript:getFilmListByActor('+actorList[k].actorId+',1)">'+actorList[k].lastName+'·'+actorList[k].firstName+'</a>&nbsp;&nbsp;&nbsp;'
                if(k!=0&&k%5==0)
                    str+='<br>';
            }
            str+='</p></div>';
        }
        $('#film').html(str);
        var str = '';
        if(result.data.hasPreviousPage)
            if(url=='/film')
                str +='<li onclick="search('+result.data.prePage+')"><a href="#">Prev</a></li>';
            else
                str +='<li onclick="getFilmList('+data.id+','+result.data.prePage+')"><a href="#">Prev</a></li>';
        else
            str +='<li class="disabled" ><a href="#">Prev</a></li>';
        // console.log(result.data.navigatepageNums[0])
        for(var j=0;j<result.data.navigatepageNums.length;j++){
            if(result.data.pageNum!=result.data.navigatepageNums[j])
                if(url=='/film')
                    str += '<li onclick="search('+result.data.navigatepageNums[j]+')"><a href="#">'+result.data.navigatepageNums[j]+'</a></li>';
                else
                    str += '<li onclick="getFilmListByActor('+data.id+','+result.data.navigatepageNums[j]+')"><a href="#">'+result.data.navigatepageNums[j]+'</a></li>';

            else
            if(url=='/film')
                str += '<li class="active" onclick="search('+result.data.navigatepageNums[j]+')"><a href="#">'+result.data.navigatepageNums[j]+'</a></li>';
            else
                str += '<li class="active" onclick="getFilmListByActor('+data.id+','+result.data.navigatepageNums[j]+')"><a href="#">'+result.data.navigatepageNums[j]+'</a></li>';
        }
        if(result.data.hasNextPage)
            if(url=='/film')
                str +='<li onclick="search('+result.data.nextPage+')"><a href="#">Next</a></li>';
            else
                str +='<li onclick="getFilmListByActor('+result.data.nextPage+')"><a href="#">Next</a></li>';
        else
            str +='<li class="disabled"  ><a href="#">Next</a></li>';

        // console.log(str);

        $('#pageination').html(str);
        $('.label').tooltip();
    })
}


function isBlank(item) {
    if(item==null||item==undefined||item=='')
        return true;
    return false;
}