<template>
  <b-container>
    <!-- partial:index.partial.html -->
    <p>&nbsp;&nbsp;</p>
    <h1 class="Head">Welcome to Opal Residential Managment Services!</h1>
    <p>&nbsp;&nbsp;</p>
    <div class="wrapper">
      <input checked type="radio" name="slider" id="slide1" />
      <input type="radio" name="slider" id="slide2" />
      <input type="radio" name="slider" id="slide3" />
      <input type="radio" name="slider" id="slide4" />
      <input type="radio" name="slider" id="slide5" />

      <div class="slider-wrapper">
        <div class="inner">
          <article>
            <div class="element">
              <div class="info top-left">
                <h3>Innis College</h3>
              </div>
              <div class="info bottom-left">
                <h3>
                  A gender-inclusive, shared-apartment-style residence, and just
                  a few steps from Robarts Library!
                </h3>
              </div>
            </div>
            <a
              href="http://starportal.utoronto.ca/StarRezPortalX/56DB73DE/13/134/The_Residences-Innis_College"
              ><img
                src="https://innis.utoronto.ca/wp-content/uploads/About-Innis-College-Feature-1.jpg"
                height="720"
            /></a>
          </article>

          <article>
            <div class="element">
              <div class="info top-left">
                <h3>Chestnut Residence</h3>
              </div>
              <div class="info bottom-left">
                <h3>
                  A residence comprised of themed communitites to suit many
                  interests, such as Engineering, Architecture, and more!
                </h3>
              </div>
            </div>
            <a
              href="https://starportal.utoronto.ca/StarRezPortalX/6F477B7F/13/139/The_Residences-University_College"
              ><img
                src="http://www.torontohotelsincanada.com/data/Photos/OriginalPhoto/8309/830953/830953823.JPEG"
                height="720"
            /></a>
          </article>

          <article>
            <div class="element">
              <div class="info top-left">
                <h3>University College</h3>
              </div>
              <div class="info bottom-left">
                <h3>
                  A beautiful building that offers mostly single rooms in both
                  modern and historic residence halls
                </h3>
              </div>
            </div>
            <a
              href="https://starportal.utoronto.ca/StarRezPortalX/6F477B7F/13/139/The_Residences-University_College"
              ><img
                class="img1"
                src="https://www.uc.utoronto.ca/sites/default/files/styles/scale_width_768/public/assets/images/UofT708_20080610_UniversityCollege_025%284x3%29.jpg?itok=J7E0rpPj"
            /></a>
          </article>

          <article>
            <div class="element">
              <div class="info top-left">
                <h3>New College</h3>
              </div>
              <div class="info bottom-left">
                <h3>
                  New College is one of the youngest and most vibrant colleges
                  at U of T. It is also the largest and boasts the highest
                  number of international students of any college.
                </h3>
              </div>
            </div>
            <a
              href="https://starportal.utoronto.ca/StarRezPortalX/493A1C6B/13/135/The_Residences-New_College"
              ><img
                src="https://www.newcollege.utoronto.ca/wp-content/uploads/2022/03/wilson.jpg?x38551"
                height="720"
            /></a>
          </article>

          <article>
            <div class="element">
              <div class="info top-left">
                <h3>St. Michael's College</h3>
              </div>
              <div class="info bottom-left">
                <h3>
                  Located on the east side of the University of Toronto’s
                  downtown campus and spanning almost 10 acres, the St.
                  Michael’s College grounds provide a charming neighbourhood to
                  the 525 students who live in our dorms each year
                </h3>
              </div>
            </div>
            <a
              href="https://starportal.utoronto.ca/StarRezPortalX/08D6E1EC/13/138/The_Residences-Trinity_College"
              ><img
                src="https://stmikes.utoronto.ca/wp-content/uploads/2018/08/Brennan-Hall-Official-800x600.jpg"
                height="720"
            /></a>
          </article>
        </div>
        <!-- .inner -->
      </div>
      <!-- .slider-wrapper -->

      <!-- <div class = "arrowLeft">
  <img src = "https://static.vecteezy.com/system/resources/previews/008/844/878/original/arrow-icon-design-free-png.png"
  width=3.2%
  height=3.2%/>
</div>


<div class = "arrowRight">
  <div class = "extraTranslate">
  <img src = "https://static.vecteezy.com/system/resources/previews/008/844/878/original/arrow-icon-design-free-png.png"
  width=3.2%
  height=3.2%/>
</div>
</div>
 -->

      <div class="slider-prev-next-control">
        <label for="slide1"></label>
        <label for="slide2"></label>
        <label for="slide3"></label>
        <label for="slide4"></label>
        <label for="slide5"></label>
      </div>
      <!-- .slider-prev-next-control -->

      <div class="slider-dot-control">
        <label for="slide1"></label>
        <label for="slide2"></label>
        <label for="slide3"></label>
        <label for="slide4"></label>
        <label for="slide5"></label>
      </div>
      <!-- .slider-dot-control -->
    </div>
  </b-container>
</template>

<script></script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
@charset "UTF-8";
/*---- NUMBER OF SLIDE CONFIGURATION ----*/
.Head {
  text-align: center;
}
.wrapper {
  max-width: 60em;
  margin: 1em auto;
  position: relative;
}

.img1 {
  z-index: 2;
}

.img2 {
  z-index: 1;
}

.arrowLeft {
  transform: translate(95.9%, -1468%);
}

.arrowRight {
  transform: translate(-95.9%, -1570%);
}

.extraTranslate {
  transform: rotateY(180deg);
}

input {
  display: none;
}

.inner {
  width: 500%;
  line-height: 0;
}

article {
  width: 20%;
  float: left;
  position: relative;
}
article img {
  width: 100%;
}

/*---- SET UP CONTROL ----*/
.slider-prev-next-control {
  height: 50px;
  position: absolute;
  top: 50%;
  width: 100%;
  -webkit-transform: translateY(-50%);
  -moz-transform: translateY(-50%);
  -ms-transform: translateY(-50%);
  -o-transform: translateY(-50%);
  transform: translateY(-50%);
}
.slider-prev-next-control label {
  display: none;
  width: 40px;
  height: 40px;
  border-radius: 50%;
  background: rgba(255, 255, 255, 0.67);
  opacity: 0.7;
}
.slider-prev-next-control label:hover {
  opacity: 1;
}

.slider-dot-control {
  position: absolute;
  width: 100%;
  bottom: 0;
  text-align: center;
}
.slider-dot-control label {
  cursor: pointer;
  border-radius: 5px;
  display: inline-block;
  width: 10px;
  height: 10px;
  background: #bbb;
  -webkit-transition: all 0.3s;
  -moz-transition: all 0.3s;
  transition: all 0.3s;
}
.slider-dot-control label:hover {
  background: #ccc;
  border-color: #777;
}

/* Info Box */
.info {
  position: absolute;
  font-style: italic;
  line-height: 20px;
  opacity: 0;
  color: #000;
  text-align: left;
  -webkit-transition: all 1000ms ease-out 600ms;
  -moz-transition: all 1000ms ease-out 600ms;
  transition: all 1000ms ease-out 600ms;
}
.info h3 {
  color: #fcfff4;
  margin: 0 0 5px;
  font-weight: normal;
  font-size: 1.5em;
  font-style: normal;
}
.info.top-left {
  top: 30px;
  left: 30px;
}
.info.top-right {
  top: 30px;
  right: 30px;
}
.info.bottom-left {
  bottom: 30px;
  left: 30px;
}
.info.bottom-right {
  bottom: 30px;
  right: 30px;
}

/* Slider Styling */
.slider-wrapper {
  width: 100%;
  overflow: hidden;
  border-radius: 5px;
  box-shadow: 1px 1px 4px #666;
  background: #fff;
  background: #fcfff4;
  -webkit-transform: translateZ(0);
  -moz-transform: translateZ(0);
  -ms-transform: translateZ(0);
  -o-transform: translateZ(0);
  transform: translateZ(0);
  -webkit-transition: all 500ms ease-out;
  -moz-transition: all 500ms ease-out;
  transition: all 500ms ease-out;
}
.slider-wrapper .inner {
  -webkit-transform: translateZ(0);
  -moz-transform: translateZ(0);
  -ms-transform: translateZ(0);
  -o-transform: translateZ(0);
  transform: translateZ(0);
  -webkit-transition: all 800ms cubic-bezier(0.77, 0, 0.175, 1);
  -moz-transition: all 800ms cubic-bezier(0.77, 0, 0.175, 1);
  transition: all 800ms cubic-bezier(0.77, 0, 0.175, 1);
}

.element {
  text-shadow: -1px -1px 0 #000, 1px -1px 0 #000, -1px 1px 0 #000,
    1px 1px 0 #000;
}

/*---- SET POSITION FOR SLIDE ----*/
#slide1:checked ~ .slider-prev-next-control label:nth-child(5)::after,
#slide5:checked ~ .slider-prev-next-control label:nth-child(4)::after,
#slide4:checked ~ .slider-prev-next-control label:nth-child(3)::after,
#slide3:checked ~ .slider-prev-next-control label:nth-child(2)::after,
#slide2:checked ~ .slider-prev-next-control label:nth-child(1)::after,
#slide5:checked ~ .slider-prev-next-control label:nth-child(1)::after,
#slide4:checked ~ .slider-prev-next-control label:nth-child(5)::after,
#slide3:checked ~ .slider-prev-next-control label:nth-child(4)::after,
#slide2:checked ~ .slider-prev-next-control label:nth-child(3)::after,
#slide1:checked ~ .slider-prev-next-control label:nth-child(2)::after {
  font-style: normal;
  font-weight: normal;
  text-decoration: inherit;
  margin: 0;
  line-height: 38px;
  font-size: 3em;
  display: block;
  color: rgba(119, 119, 119, 0);
}

#slide5:checked ~ .slider-prev-next-control label:nth-child(1)::after,
#slide4:checked ~ .slider-prev-next-control label:nth-child(5)::after,
#slide3:checked ~ .slider-prev-next-control label:nth-child(4)::after,
#slide2:checked ~ .slider-prev-next-control label:nth-child(3)::after,
#slide1:checked ~ .slider-prev-next-control label:nth-child(2)::after {
  content: "";
  padding-left: 15px;
}

#slide5:checked ~ .slider-prev-next-control label:nth-child(1),
#slide4:checked ~ .slider-prev-next-control label:nth-child(5),
#slide3:checked ~ .slider-prev-next-control label:nth-child(4),
#slide2:checked ~ .slider-prev-next-control label:nth-child(3),
#slide1:checked ~ .slider-prev-next-control label:nth-child(2) {
  display: block;
  float: right;
  margin-right: 5px;
}

#slide1:checked ~ .slider-prev-next-control label:nth-child(5),
#slide5:checked ~ .slider-prev-next-control label:nth-child(4),
#slide4:checked ~ .slider-prev-next-control label:nth-child(3),
#slide3:checked ~ .slider-prev-next-control label:nth-child(2),
#slide2:checked ~ .slider-prev-next-control label:nth-child(1) {
  display: block;
  float: left;
  margin-left: 5px;
}

#slide1:checked ~ .slider-prev-next-control label:nth-child(5)::after,
#slide5:checked ~ .slider-prev-next-control label:nth-child(4)::after,
#slide4:checked ~ .slider-prev-next-control label:nth-child(3)::after,
#slide3:checked ~ .slider-prev-next-control label:nth-child(2)::after,
#slide2:checked ~ .slider-prev-next-control label:nth-child(1)::after {
  content: "";
  padding-left: 8px;
}

#slide5:checked ~ .slider-dot-control label:nth-child(5),
#slide4:checked ~ .slider-dot-control label:nth-child(4),
#slide3:checked ~ .slider-dot-control label:nth-child(3),
#slide2:checked ~ .slider-dot-control label:nth-child(2),
#slide1:checked ~ .slider-dot-control label:nth-child(1) {
  background: #333;
}

#slide5:checked ~ .slider-wrapper article:nth-child(5) .info,
#slide4:checked ~ .slider-wrapper article:nth-child(4) .info,
#slide3:checked ~ .slider-wrapper article:nth-child(3) .info,
#slide2:checked ~ .slider-wrapper article:nth-child(2) .info,
#slide1:checked ~ .slider-wrapper article:nth-child(1) .info {
  opacity: 1;
}

#slide1:checked ~ .slider-wrapper .inner {
  margin-left: 0%;
}
#slide2:checked ~ .slider-wrapper .inner {
  margin-left: -100%;
}
#slide3:checked ~ .slider-wrapper .inner {
  margin-left: -200%;
}
#slide4:checked ~ .slider-wrapper .inner {
  margin-left: -300%;
}
#slide5:checked ~ .slider-wrapper .inner {
  margin-left: -400%;
}
/*---- TABLET ----*/
@media only screen and (max-width: 850px) and (min-width: 450px) {
  .slider-wrapper {
    border-radius: 0;
  }
}
/*---- MOBILE----*/
@media only screen and (max-width: 450px) {
  .slider-wrapper {
    border-radius: 0;
  }

  .slider-wrapper .info {
    opacity: 0;
  }
}
@media only screen and (min-width: 850px) {
  body {
    padding: 0 80px;
  }
}
</style>
