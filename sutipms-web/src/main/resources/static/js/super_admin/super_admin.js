function companyDatatable(){
    $('#companys_datatable').DataTable( {
        "bPaginate": true,
        "iDisplayStart":0,
        "bProcessing" : true,
        "bServerSide" : true,
        "sAjaxSource" : "../super-admin/home",
        "language": {
            "infoFiltered": ""
        }

    });
}
