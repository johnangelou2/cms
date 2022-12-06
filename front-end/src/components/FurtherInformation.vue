<template>
  <div class="Information Page">
    <b-container>
      <h1 id="furtherinformation">
        Further Information
      </h1>
      <h2 class="Purpose" id="purpose">Purpose</h2>
      <hr size="5px" />
      <p class="description" id="purpose description">
        The purpose of this website is to provide administrtors with a resource
        to keep track of all activities found within a residence. This website
        allows administrators and dons to track the following aspects of a
        residence:
      </p>
      <ul>
        <li>
          Students in a residence
        </li>
        <li>Rooms in a residence</li>
        <li>Reports of activities which occur in a residence</li>
      </ul>
      <hr size="5px" />
      <h4>Students:</h4>
      <p>
        The website provides functionality for admins to create, update, delete,
        and read about students in the database.
      </p>
      <p>
        Each student is given a Name (First and Last), Student Number, Date of
        Birth, Phone Number, and Email. In addition to adding a student, they
        can also remove the student whenever needed, and edit their information.
        Admins will always be able to read all student information so long as
        they are logged into the website
      </p>
      <hr size="5px" />
      <h4>Reports:</h4>

      <p>
        The website also provides functionality for admins to create, update,
        delete, and read all reports about activities in the database. These
        activities are found in the form of reports
      </p>
      <p>
        The reports tab works similarly to the students function, as
        administrators are able to append information about the report id,
        report date and time, a description of the report, the report type
        (violent or nonviolent), the status of the report, and the
        administrators name.
      </p>
      <hr size="5px" />
      <h4>Rooms:</h4>
      <p>
        Rooms, similar to the two sections above, contain information about the
        rooms which residences are placed in. Administrators cannot add rooms
        (there are a fixed amount in each residence), however they update and
        delete rooms
      </p>

      <p>
        Each room has a residence ID, a room ID, a room type, and capacity.
        These describe the size of the rooms and the type of room. The residence
        ID also gives information of the residence the room belongs to, and
        residences are identical to those on the residence information page.
        More inforamtion on the residences shown can be found at the UofT
        website.
      </p>
      <hr size="5px" />

      <h3>A Note on Security</h3>
      <p>
        The website requires administrators to log into the website to view
        information about students, rooms, and reports. This is implemented to
        ensure the security of the information contained on the website. We are
        aware of the element of confidentiality regarding the information on the
        website and implemented these measures to ensure sensitivie information
        is protected.
      </p>

      <hr size="5px" />

      <h2 class="Purpose" id="purpose">Meet The Team!</h2>
      <div class="img-container">
        <figure>
          <img
            src="https://media-exp1.licdn.com/dms/image/D5603AQHOpBn_yu1osQ/profile-displayphoto-shrink_400_400/0/1665253113814?e=1675900800&v=beta&t=5ppFhGcZ72HweV0aqdmFrwBIhkCVwCevcA8kJywpXT4"
            alt="Junwon Kang"
            style="width:50%"
          />
          <figcaption class="figure">Junwon Kang</figcaption>
        </figure>
        <figure>
          <img
            src="https://media-exp1.licdn.com/dms/image/C4D03AQEN6HCLvV82ow/profile-displayphoto-shrink_400_400/0/1611343482255?e=1675900800&v=beta&t=UhWqgOkNDMiSfKntZc328zes5HUGknCK099z9DDMrps"
            alt="Minseok Song"
            style="width:50%"
          />
          <figcaption class="figure">Minseok Song</figcaption>
        </figure>
        <figure>
          <img
            src="https://media-exp1.licdn.com/dms/image/C4E03AQEf8FjghssTpA/profile-displayphoto-shrink_400_400/0/1654287451014?e=1675900800&v=beta&t=ribNTndHQCuHrTSPxg6S-jy53DnQ797a7YKfgHV_91w"
            alt="David Tong"
            style="width:50%"
          />
          <figcaption class="figure">David Tong</figcaption>
        </figure>
        <figure>
          <img
            src="https://media-exp1.licdn.com/dms/image/C5603AQFCQvfAE0L3og/profile-displayphoto-shrink_400_400/0/1658070123231?e=1675900800&v=beta&t=v3uzMP_0GB8jr0rIZKn_83khach_TarwuZP7lxkxGho"
            alt="John Angelou"
            style="width:50%"
          />
          <figcaption class="figure">John Angelou</figcaption>
        </figure>
        <figure>
          <img
            src="https://media-exp1.licdn.com/dms/image/C4D03AQHXV3ct2X3DCg/profile-displayphoto-shrink_400_400/0/1619979752508?e=1675900800&v=beta&t=CjNPMkTVSeITiu4CR_7WwCcd4Pz70o_jR4QW-Yj_jcY"
            alt="Cole Stotland"
            style="width:50%"
          />
          <figcaption class="figure">Cole Stotland</figcaption>
        </figure>
        <figure>
          <img
            src="https://media-exp1.licdn.com/dms/image/C4E03AQF2YAr8PvPP1g/profile-displayphoto-shrink_400_400/0/1606345714625?e=1675900800&v=beta&t=0LdzbJa-L1pMrrYa1A_h8Nh-UQEtZGIMGUyx4kwK2Uw"
            alt="Jeremie Collette"
            style="width:50%"
          />
          <figcaption class="figure">Jeremie Collette</figcaption>
        </figure>
        <figure>
          <img
            src="https://media-exp1.licdn.com/dms/image/D5603AQGgRAUxtifGSA/profile-displayphoto-shrink_400_400/0/1667803847827?e=1675900800&v=beta&t=H_8BjF56VH1FPXzWFB80Fzr2H9kavVfwXAYIFRakicw"
            alt="Mukund Hari"
            style="width:50%"
          />
          <figcaption class="figure">Mukund Hari</figcaption>
        </figure>
      </div>
      <aside>
        <h4>Disclaimer</h4>
        <p>
          Everything in this website is subject to change, and all information
          on this website is entirely made up.
        </p>
      </aside>
    </b-container>
  </div>
</template>

<script></script>

<style>
#furtherinformation {
  text-decoration: underline;
}

.Purpose {
  background-color: rgb(193, 222, 224);
}

aside {
  background-color: #f7f7f7;
  border-top: 5px solid #1098ad;
  border-bottom: 5px solid #1098ad;
  text-align: center;
}

.img-container {
  display: flex;
  justify-content: center;
}

.img-container figure {
  margin-left: 5px;
  margin-right: 5px;
}

.img-container figcaption {
  margin-left: -2px;
  margin-right: 5px;
}
</style>
