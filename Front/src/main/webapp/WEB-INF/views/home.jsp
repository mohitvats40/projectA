

		<div class="row">
			<div class="col-sm-12">
				<div class="carousel slide" data-interval="1000" id="myCarousel">
					<ol class="carousel-indicators">
						<li class="active" data-slide-to="0" data-target="#myCarousel"></li>
						<li data-slide-to="1" data-target="#myCarousel"></li>
						<li data-slide-to="2" data-target="#myCarousel"></li>
						<li data-slide-to="3" data-target="#myCarousel"></li>
						<li data-slide-to="4" data-target="#myCarousel"></li>
						<li data-slide-to="5" data-target="#myCarousel"></li>
						<li data-slide-to="6" data-target="#myCarousel"></li>
					</ol>
					<div class="carousel-inner">
						<div class="item active" id="slide1">
							<img src="${images}/lap2.jpg" style="height: 700px; width: 100%;">
							<div class="carousel-caption">
								<h4>this is a slide</h4>

							</div>
						</div>
						<div class="item" id="slide2">
							<img src="${images}/cam1.jpg" style="height: 700px; width: 100%;">
							<div class="carousel-caption">
								<h4>this is a slide</h4>

							</div>
						</div>
						<div class="item" id="slide3">
							<img src="${images}/pr1.jpg" style="height: 700px; width: 100%;">
							<div class="carousel-caption">
								<h4>this is a slide</h4>

							</div>
						</div>
						<div class="item" id="slide4">
							<img src="${images}/lap1.jpg" style="height: 700px; width: 100%;">
							<div class="carousel-caption">
								<h4>this is a slide</h4>

							</div>
						</div>
						<div class="item" id="slide5">
							<img src="${images}/er2.jpg" style="height: 700px; width: 100%;">
							<div class="carousel-caption">
								<h4>this is a slide</h4>

							</div>
						</div>
						<div class="item" id="slide6">
							<img src="${images}/er1.jpg" style="height: 700px; width: 100%;">
							<div class="carousel-caption">
								<h4>this is a slide</h4>
							</div>
						</div>
					</div>
					<a class="left carousel-control" data-slide="prev"
						href="#myCarousel"><span class="icon-prev"></span></a> <a
						class="right carousel-control" data-slide="next"
						href="#myCarousel"><span class="icon-next"></span></a>
				</div>
			</div>
		</div>
	
	<div class="container">
		<h2>Collapse</h2>
		<p>
			<strong>Note:</strong> The <strong>data-parent</strong> attribute
			makes sure that all collapsible elements under the specified parent
			will be closed when one of the collapsible item is shown.
		</p>
		<div class="panel-group" id="accordion">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordion"
							href="#collapse1">Collapsible Group 1</a>
					</h4>
				</div>
				<div id="collapse1" class="panel-collapse collapse in">
					<div class="panel-body">Lorem ipsum dolor sit amet,
						consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
						labore et dolore magna aliqua. Ut enim ad minim veniam, quis
						nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
						consequat.</div>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordion"
							href="#collapse2">Collapsible Group 2</a>
					</h4>
				</div>
				<div id="collapse2" class="panel-collapse collapse">
					<div class="panel-body">Lorem ipsum dolor sit amet,
						consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
						labore et dolore magna aliqua. Ut enim ad minim veniam, quis
						nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
						consequat.</div>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordion"
							href="#collapse3">Collapsible Group 3</a>
					</h4>
				</div>
				<div id="collapse3" class="panel-collapse collapse">
					<div class="panel-body">Lorem ipsum dolor sit amet,
						consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
						labore et dolore magna aliqua. Ut enim ad minim veniam, quis
						nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
						consequat.</div>
				</div>
			</div>
		</div>
	</div>
