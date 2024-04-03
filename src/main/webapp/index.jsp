<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.pharmacy.bean.MedicalStoreData" %>
<%@ page import="com.pharmacy.Admin.Administrator" %>
<%@ page import="com.pharmacy.bean.UserData" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>Pharmacy</title>
    <meta content="" name="description">
    <meta content="" name="keywords">

    <!-- Favicons -->
    <link href="assets/img/favicon.png" rel="icon">
    <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

    <!-- Vendor CSS Files -->
    <link href="all.min.css" rel="stylesheet">
    <link href="animate.min.css" rel="stylesheet">
    <link href="bootstrap.min.css" rel="stylesheet">
    <link href="bootstrap-icons.css" rel="stylesheet">
    <link href="boxicons.min.css" rel="stylesheet">
    <link href="glightbox.min.css" rel="stylesheet">
    <link href="remixicon.css" rel="stylesheet">
    <link href="swiper-bundle.min.css" rel="stylesheet">

    <!-- Template Main CSS File -->
    <link href="style.css" rel="stylesheet">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <style>
        /* Custom CSS to change icon color to blue */
        .blue-icon {
            color: #3c9cdb;
        }
        #hero{
          background-image: linear-gradient(120deg, #a1c4fd 0%, #c2e9fb 100%);
        }
        .aboutButton{
 background-color: #3c9cdb;
           border-radius: 5px;
          color:#3c9cdb;
          color: white;
        }
    </style>


</head>

<body>

<%

UserData user = null;
Administrator administrator = null;
int a = 0,b=0;
if(session.getAttribute("userInfo")!=null){
user = (UserData) session.getAttribute("userInfo");
a = 1;
}

if(administrator!=null){
administrator = (Administrator) session.getAttribute("administrator");
b = 1;
}
%>

<!-- ======= Top Bar ======= -->
<div id="topbar" class="d-flex align-items-center fixed-top">
    <div class="container d-flex justify-content-between">
        <div class="contact-info d-flex align-items-center">
            <i class="fas fa-envelope blue-icon"></i> <a href="minorpharmacy@gmail.com">PharmEase@gmail.com</a>
            <i class="fas fa-phone blue-icon"></i> 0123456789
        </div>
        <div class="d-none d-lg-flex social-links align-items-center">
            <a href="#" class="twitter"><i class="fab fa-twitter blue-icon"></i></a>
            <a href="#" class="facebook"><i class="fab fa-facebook blue-icon"></i></a>
            <a href="#" class="fab fa-instagram blue-icon"></a>
            <a href="#" class="linkedin"><i class="fab fa-linkedin blue-icon"></i></i></a>
        </div>
    </div>
</div>

<!-- ======= Header ======= -->
<header id="header" class="fixed-top">
    <div class="container d-flex align-items-center">

        <h1 class="logo me-auto"><a href="index.html">PharmEase</a></h1>

        <nav id="navbar" class="navbar order-last order-lg-0">
            <ul>
                <li><a class="nav-link scrollto active" href="#hero">Home</a></li>
                <li><a class="nav-link scrollto" href="About.html">About</a></li>
                <li><a class="nav-link scrollto" href="#services">Categories</a></li>


                <li><a class="nav-link scrollto" href="AdminLogin.html">AdministratorLogin</a></li>

                <li><a class="nav-link scrollto" href="#doctors">Brands</a></li>

                <li><a class="nav-link scrollto" href="SearchMedican.jsp">search</a></li>
                <li><a class="nav-link scrollto" href="#gallery">Offers</a></li>
                <li><a class="nav-link scrollto" href="#contact">Contact</a></li>
            </ul>
            <i class="bi bi-list mobile-nav-toggle"></i>
        </nav><!-- .navbar -->

        <%
        if(a == 0) {
        out.print("<a href=\"Login.html\" class=\"appointment-btn scrollto\"><span class=\"d-none d-md-inline\">Login/</span> Signup</a>");
        } else {
        out.print("<a href=\"Login.html\" class=\"appointment-btn scrollto\"><span class=\"d-none d-md-inline\">" + user.getName() + "</span></a>");
        }
        %>


    </div>
</header><!-- End Header -->

<!-- ======= Hero Section ======= -->
<section id="hero" class="d-flex align-items-center">
    <div class="container">
        <h1>Welcome to PharmEase</h1>
        <h2>Your Health, Your Hub: Connecting You to Nearby Pharmacies and Medicine Availability!</h2>
        <a href="#about" class="btn-get-started scrollto">Get Started</a>
    </div>
</section><!-- End Hero -->

<main id="main">

    <!-- ======= Why Us Section ======= -->
    <section id="why-us" class="why-us">
        <div class="container">

            <div class="row">
                <div class="col-lg-4 d-flex align-items-stretch">
                    <div class="content">
                        <h3>Why Choose Pharmacy?</h3>
                        <p>
                            Elevate Your Healthcare Experience with Pharmacy:Unmatched Precision in Pharmacy Locating, Effortless Navigation, Up-to-the-Minute Information, and a Supportive Community. Choose Confidence, Choose Convenience – Your Wellness, Our Priority.
                        </p>
                        <div class="text-center">
                            <a href="About.html" class="more-btn">Learn More</a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-8 d-flex align-items-stretch">
                    <div class="icon-boxes d-flex flex-column justify-content-center">
                        <div class="row">
                            <div class="col-xl-4 d-flex align-items-stretch">
                                <div class="icon-box mt-4 mt-xl-0">
                                    <i class="fas fa-map-marker-alt blue-icon"></i>
                                    <h4>Effortless Location-Based Searches</h4>
                                    <p>Quickly find nearby medical stores based on location, making healthcare accessibility convenient.</p>
                                </div>
                            </div>
                            <div class="col-xl-4 d-flex align-items-stretch">
                                <div class="icon-box mt-4 mt-xl-0">
                                    <i class="fas fa-lightbulb blue-icon"></i>
                                    <h4>Personalized Recommendations</h4>
                                    <p>Receive tailored suggestions for medical stores based on user behavior, enhancing the overall search experience.</p>
                                </div>
                            </div>
                            <div class="col-xl-4 d-flex align-items-stretch">
                                <div class="icon-box mt-4 mt-xl-0">
                                    <i class="fas fa-hands-helping blue-icon"></i>
                                    <h4>Overall Health and Wellness Support</h4>
                                    <p>Enhance the overall health and wellness journey by providing easy access to essential healthcare resources.</p>
                                </div>
                            </div>
                        </div>
                    </div><!-- End .content-->
                </div>
            </div>

        </div>
    </section><!-- End Why Us Section -->

    <!-- ======= Services Section ======= -->
    <section id="services" class="services">
        <div class="container">

            <div class="section-title">
                <h2>Shop By Category</h2>

            </div>

            <div class="row">
                <div class="col-lg-4 col-md-6 d-flex align-items-stretch">
                    <div class="icon-box">
                        <div class="icon"><i class="fas fa-heartbeat"></i></div>
                        <h4><a href="">Heart Diseases</a></h4>
                        <p>Voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi</p>
                    </div>
                </div>

                <div class="col-lg-4 col-md-6 d-flex align-items-stretch mt-4 mt-md-0">
                    <div class="icon-box">
                        <div class="icon"><i class="fa fa-thermometer"></i></div>
                        <h4><a href="">Cold and Fever</a></h4>
                        <p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore</p>
                    </div>
                </div>

                <div class="col-lg-4 col-md-6 d-flex align-items-stretch mt-4 mt-lg-0">
                    <div class="icon-box">
                        <div class="icon"><i class="fas fa-hospital-user"></i></div>
                        <h4><a href="">Full Body Checkup</a></h4>
                        <p>Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia</p>
                    </div>
                </div>

                <div class="col-lg-4 col-md-6 d-flex align-items-stretch mt-4">
                    <div class="icon-box">
                        <div class="icon"><i class="fa fa-female"></i></div>
                        <h4><a href="">Women Care</a></h4>
                        <p>At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis</p>
                    </div>
                </div>

                <div class="col-lg-4 col-md-6 d-flex align-items-stretch mt-4">
                    <div class="icon-box">
                        <div class="icon"><i class="fa-solid fa-virus-covid"></i></div>
                        <h4><a href="">Covid Care</a></h4>
                        <p>Quis consequatur saepe eligendi voluptatem consequatur dolor consequuntur</p>
                    </div>
                </div>

                <div class="col-lg-4 col-md-6 d-flex align-items-stretch mt-4">
                    <div class="icon-box">
                        <div class="icon"><i class="fa fa-medkit"></i></div>
                        <h4><a href="">Medical-Kit</a></h4>
                        <p>Modi nostrum vel laborum. Porro fugit error sit minus sapiente sit aspernatur</p>
                    </div>
                </div>

            </div>

        </div>
    </section><!-- End Services Section -->

    <!-- ======= Brands Section ======= -->
    <section id="doctors" class="doctors">
        <div class="container">

            <div class="section-title">
                <h2>Brands in Focus</h2>

            </div>

            <div class="row">

                <div class="col-lg-6">
                    <div class="member d-flex align-items-start">
                        <div class="pic">
                            <a href="himalaya.html"><img src="img/doctors/doctors-1.jpg" class="img-fluid" alt=""></div></a>
                        <div class="member-info">
                            <br><br>
                            <h4>Himalaya</h4>

                            <p>Khush Raho, Khushaal Raho</p><br>
                            <p>Up to 35% off</p>

                        </div>
                    </div>
                </div>

                <div class="col-lg-6 mt-4 mt-lg-0">
                    <div class="member d-flex align-items-start">
                        <div class="pic">
                            <a href="dabur.html"><img src="img/doctors/doctors-2.jpg" class="img-fluid" alt=""></a></div>
                        <div class="member-info">
                            <br><br>
                            <h4>Dabur</h4>

                            <p>Celebrate Life</p><br>
                            <p>Up to 35% off</p>
                        </div>
                    </div>
                </div>

                <div class="col-lg-6 mt-4">
                    <div class="member d-flex align-items-start">
                        <div class="pic">
                            <a href="revital.html"><img src="img/doctors/doctors-3.jpg" class="img-fluid" alt=""></a></div>
                        <div class="member-info">
                            <br><br>
                            <h4>Revital</h4>

                            <p>Apni body ki suno</p><br>
                            <p>Up to 35% off</p>
                        </div>
                    </div>
                </div>

                <div class="col-lg-6 mt-4">
                    <div class="member d-flex align-items-start">
                        <div class="pic"><img src="img/doctors/doctors-4.jpg" class="img-fluid" alt=""></div>
                        <div class="member-info">
                            <br><br>
                            <h4>Revital</h4>

                            <p>Apni body ki suno</p><br>
                            <p>Up to 35% off</p>
                        </div>
                    </div>
                </div>

                <!-- ======= discount offers ======= -->
                <section id="gallery" class="gallery">
                    <div class="container">

                        <div class="section-title">
                            <h2>Discount Offers</h2>
                            <p>Magnam dolores commodi suscipit. Necessitatibus eius consequatur ex aliquid fuga eum quidem. Sit sint consectetur velit. Quisquam quos quisquam cupiditate. Et nemo qui impedit suscipit alias ea. Quia fugiat sit in iste officiis commodi quidem hic quas.</p>
                        </div>
                    </div>

                    <div class="container-fluid">
                        <div class="row g-0">

                            <div class="col-lg-3 col-md-4">
                                <div class="gallery-item">
                                    <a href="img/gallery/gallery-1.jpg" class="galelry-lightbox">
                                        <img src="img/gallery/gallery-1.jpg" alt="" class="img-fluid">
                                    </a>
                                </div>
                            </div>

                            <div class="col-lg-3 col-md-4">
                                <div class="gallery-item">
                                    <a href="img/gallery/gallery-2.jpg" class="galelry-lightbox">
                                        <img src="img/gallery/gallery-2.jpg" alt="" class="img-fluid">
                                    </a>
                                </div>
                            </div>

                            <div class="col-lg-3 col-md-4">
                                <div class="gallery-item">
                                    <a href="img/gallery/gallery-3.jpg" class="galelry-lightbox">
                                        <img src="img/gallery/gallery-3.jpg" alt="" class="img-fluid">
                                    </a>
                                </div>
                            </div>

                            <div class="col-lg-3 col-md-4">
                                <div class="gallery-item">
                                    <a href="img/gallery/gallery-4.jpg" class="galelry-lightbox">
                                        <img src="img/gallery/gallery-4.jpg" alt="" class="img-fluid">
                                    </a>
                                </div>
                            </div>

                            <div class="col-lg-3 col-md-4">
                                <div class="gallery-item">
                                    <a href="img/gallery/gallery-5.jpg" class="galelry-lightbox">
                                        <img src="img/gallery/gallery-5.jpg" alt="" class="img-fluid">
                                    </a>
                                </div>
                            </div>

                            <div class="col-lg-3 col-md-4">
                                <div class="gallery-item">
                                    <a href="img/gallery/gallery-6.jpg" class="galelry-lightbox">
                                        <img src="img/gallery/gallery-6.jpg" alt="" class="img-fluid">
                                    </a>
                                </div>
                            </div>

                            <div class="col-lg-3 col-md-4">
                                <div class="gallery-item">
                                    <a href="img/gallery/gallery-7.jpg" class="galelry-lightbox">
                                        <img src="img/gallery/gallery-7.jpg" alt="" class="img-fluid">
                                    </a>
                                </div>
                            </div>

                            <div class="col-lg-3 col-md-4">
                                <div class="gallery-item">
                                    <a href="img/gallery/gallery-8.jpg" class="galelry-lightbox">
                                        <img src="img/gallery/gallery-8.jpg" alt="" class="img-fluid">
                                    </a>
                                </div>
                            </div>

                        </div>

                    </div>
                </section><!-- End discount offers-->

                <!-- ======= Contact Section ======= -->
                <section id="contact" class="contact">
                    <div class="container">

                        <div class="section-title">
                            <h2>Contact</h2>
                            <p>Magnam dolores commodi suscipit. Necessitatibus eius consequatur ex aliquid fuga eum quidem. Sit sint consectetur velit. Quisquam quos quisquam cupiditate. Et nemo qui impedit suscipit alias ea. Quia fugiat sit in iste officiis commodi quidem hic quas.</p>
                        </div>
                    </div>

                    <div>
                        <iframe style="border:0; width: 100%; height: 350px;" src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d12097.433213460943!2d-74.0062269!3d40.7101282!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0xb89d1fe6bc499443!2sDowntown+Conference+Center!5e0!3m2!1smk!2sbg!4v1539943755621" frameborder="0" allowfullscreen></iframe>
                    </div>

                    <div class="container">
                        <div class="row mt-5">

                            <div class="col-lg-4">
                                <div class="info">
                                    <div class="address">
                                        <i class="fas fa-map-marker-alt blue-icon"></i>
                                        <h4>Location:</h4>
                                        <p>Nariyal Khada Bhopal MP 462038</p>
                                    </div>

                                    <div class="email">
                                        <i class="fas fa-envelope blue-icon"></i>
                                        <h4>Email:</h4>
                                        <p>PharmEase@example.com</p>
                                    </div>

                                    <div class="phone">
                                        <i class="fas fa-phone blue-icon"></i>
                                        <h4>Call:</h4>
                                        <p>+91 9986573782</p>
                                    </div>

                                </div>

                            </div>

                            <div class="col-lg-8 mt-5 mt-lg-0">

                                <div class="text-center"><h3>FeedBack & any Suggestions</h3></div><br>
                                <form action="FeedBack" method="post" class="php-email-form">
                                    <div class="row">
                                        <div class="col-md-6 form-group">
                                            <input type="text" name="name" class="form-control" id="name" placeholder="Your Name" required>
                                        </div>
                                        <div class="col-md-6 form-group mt-3 mt-md-0">
                                            <input type="email" class="form-control" name="email" id="email" placeholder="Your Email" required>
                                        </div>
                                    </div>
                                    <div class="form-group mt-3">
                                        <input type="text" class="form-control" name="subject" id="subject" placeholder="Subject" required>
                                    </div>
                                    <div class="form-group mt-3">
                                        <textarea class="form-control" name="message" rows="5" placeholder="Message" required></textarea>
                                    </div>
                                    <div class="my-3">
                                        <div class="loading">Loading</div>
                                        <div class="error-message"></div>
                                        <div class="sent-message">Your message has been sent. Thank you!</div>
                                    </div>
                                    <div class="text-center"><button type="submit">Send Message</button></div>
                                </form>

                            </div>

                        </div>

                    </div>
                </section><!-- End Contact Section -->

</main><!-- End #main -->

<!-- ======= Footer ======= -->
<footer id="footer">

    <div class="footer-top">
        <div class="container">
            <div class="row">

                <div class="col-lg-3 col-md-6 footer-contact">
                    <h3>PharmEasev</h3>
                    <p>
                        Gandhi-Nagar <br>
                        Bhopal Mp <br>
                        India - 462036 <br><br>
                        <strong>Phone:</strong>0123456789<br>
                        <strong>Email:</strong>PharmEase@gmail.com<br>
                    </p>
                </div>


                <div class="col-lg-2 col-md-6 footer-links">
                    <h4>Company</h4>
                    <ul>
                        <li><i class="fas fa-check blue-icon"></i> <a href="#">Home</a></li>
                        <li><i class="fas fa-check blue-icon"></i> <a href="#">About us</a></li>
                        <li><i class="fas fa-check blue-icon"></i> <a href="#">Services</a></li>
                        <li><i class="fas fa-check blue-icon"></i> <a href="#">Terms and Conditions</a></li>
                        <li><i class="fas fa-check blue-icon"></i> <a href="#">Privacy policy</a></li>
                    </ul>
                </div>

                <div class="col-lg-3 col-md-6 footer-links">
                    <h4>CATEGORIES</h4>
                    <ul>
                        <li><i class="fas fa-check blue-icon"></i> <a href="#">Heart Diseases</a></li>
                        <li><i class="fas fa-check blue-icon"></i> <a href="#">Cold and Fever</a></li>
                        <li><i class="fas fa-check blue-icon"></i> <a href="#">Full Body Checkup</a></li>
                        <li><i class="fas fa-check blue-icon"></i> <a href="#">Women Care</a></li>
                        <li><i class="fas fa-check blue-icon"></i> <a href="#">Covid Care</a></li>
                        <li><i class="fas fa-check blue-icon"></i> <a href="#">Medical-Kit</a></li>
                    </ul>
                </div>

                <div class="col-lg-4 col-md-6 footer-newsletter">
                    <h2>About Us.</h2>
                    <p>We provide information about pharmacies near you, ensuring you have easy access to medication when you need it most.</p>
                    <p>Our website is dedicated to helping you find the nearest pharmacies, along with details about their working hours, contact information, and services offered.</p>
                    <a href="About.html"><button type="submit" class="aboutButton">Learn More</button></a>

                </div>

            </div>
        </div>
    </div>

    <div class="container d-md-flex py-4">

        <div class="me-md-auto text-center text-md-start">
            <div class="copyright">
                &copy; Copyright <strong><span>Medilab</span></strong>. All Rights Reserved
            </div>
            <div class="credits">
                All the links in the footer should remain intact.
                You can delete the links only if you purchased the pro version.
                Licensing information: https://bootstrapmade.com/license/
                Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/medilab-free-medical-bootstrap-theme/
                Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
            </div>
        </div>
    </div>
</footer><!-- End Footer -->

<div id="preloader"></div>
<a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="far fa-hand-pointer blue-icon"></i></a>

<script src="purecounter_vanilla.js"></script>
<script src="bootstrap.bundle.min.js"></script>
<script src="glightbox.min.js"></script>
<script src="swiper-bundle.min.js"></script>
<script src="validate.js"></script>

<!-- Template Main JS File -->
<script src="main.js"></script>


</body>

</html>