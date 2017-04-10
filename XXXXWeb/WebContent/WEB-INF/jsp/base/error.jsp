
<body>
<div style="height: 400px;" class="container">
<div style="float:left;margin-left:300px">
<p style="margin-top: 100px;margin-left:100px; font-size: 32">Oops!!</p>
<p style=" font-size: 22">Un mono metio la cola!!!</p>
</div>
<div style="margin-left: 200px">
<img alt="programmers"  src="img/error_interno.jpg"> 

</div>

<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
  Ver Excepcion
</button>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Excepcion</h4>
      </div>
      <div class="modal-body">
        <p>${message}</p>
        <p>${stack}</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>

      </div>
    </div>
  </div>
</div>
</div>
</body>
