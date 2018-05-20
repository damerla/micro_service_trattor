var table ;
function companyDataTable()
{
   // alert("hari");
    var reqURL = "../super-admin/home"
    if (table != null) {
        $('#companys_datatable').DataTable().destroy();
    }
    table = $('#companys_datatable').DataTable(
            {
                "bProcessing" : true,
                "bServerSide" : true,
                "searching" : false,
                "lengthChange" : false,
                "bSortable" : false,
                "stateSave" : false,
                "deferRender" : true,
                "iDisplayStart": 0,
                //"iDisplayLength":pageNo,
                "sAjaxSource" : reqURL,
                "columns" : [
                    {
                        "data" : "companyName",
                        "title" : "Company Name",
                        "name" : "companyName"
                    }, {
                        "data" : "phoneNo",
                        "title" : "Phone No",
                        "name" : "phoneNo"
                    }, {
                        "data" : "email",
                        "title" : "Email",
                        "name" : "email"
                    },
                    {
                        "data" : "owner",
                        "title" : "Owner Name",
                        "name" : "ownerName"
                    },
                    {
                        "render" : function(data, type, row, full, meta) {
                            var activeStatusTemp="";
                                activeStatusTemp='<a href="../setup-room/activate?activationStatus='+row.companyName+'&encryptID='+row.companyName+'"><img src="../images/actions/inactive.png" class="listactions" alt="activate" title="Activate" /></a> '+
                                    '<a href="#" onclick="deleteSetup(\''+'setup-room' +'\',\''+row.companyName+'\'); "><img src="../images/actions/delete_ico.png" class="listactions" alt="Delete" title="Delete" /></a>';

                            return '<a href="#" data-toggle="modal" data-target="#room_new" onclick="edit(\''+'setup-room' +'\',\'' +row.companyName+ '\'); ">'+
                                '<img src="../images/actions/edit_details.png" class="listactions" alt="Edit" title="Edit" /></a> &nbsp;'+activeStatusTemp;

                        },
                        "title": "Actions"

                    }
                ],
                "oLanguage" : {
                    "oPaginate" : {
                        "sNext" : '<span class="pagination-default"></span><span class="pagination-fa"><i class="fa fa-chevron-right" ></i></span>',
                        "sPrevious" : '<span class="pagination-default"></span><span class="pagination-fa"><i class="fa fa-chevron-left" ></i></span>'
                    }
                },
                "bJQueryUI" : true
            });
}