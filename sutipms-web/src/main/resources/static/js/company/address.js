var table ;
function addressDatatable()
{
     alert("hari");
    var reqURL = "../address/address"
    if (table != null) {
        $('#address_datatable').DataTable().destroy();
    }
    table = $('#address_datatable').DataTable(
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
                    "data" : "city",
                    "title" : "City Name",
                    "name" : "city"
                }, {
                    "data" : "state",
                    "title" : "State",
                    "name" : "state"
                }, {
                    "data" : "pinCode",
                    "title" : "Pin Code",
                    "name" : "pinCode"
                },

                {
                    "render" : function(data, type, row, full, meta) {
                        var activeStatusTemp="";
                        activeStatusTemp='<a href="../setup-room/activate?activationStatus='+row.pinCode+'&encryptID='+row.pinCode+'"><img src="../images/actions/inactive.png" class="listactions" alt="activate" title="Activate" /></a> '+
                            '<a href="#" onclick="deleteSetup(\''+'setup-room' +'\',\''+row.companyName+'\'); "><img src="../images/actions/delete_ico.png" class="listactions" alt="Delete" title="Delete" /></a>';

                        return '<a href="#" data-toggle="modal" data-target="#room_new" onclick="edit(\''+'setup-room' +'\',\'' +row.pinCode+ '\'); ">'+
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