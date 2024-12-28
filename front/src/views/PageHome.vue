<template>
  <div class="home-container">


    <!-- Main Content Section -->
    <section class="main-content">
      <h2>리뷰 서비스</h2>

    </section>


  </div>
</template>

<script>
export default {
  data() {
    return {
      features: [
        {
          title: 'Feature 1',
          description: 'Description for feature 1.',
          image: 'https://via.placeholder.com/300',
          link: '#feature1'
        },
        {
          title: 'Feature 2',
          description: 'Description for feature 2.',
          image: 'https://via.placeholder.com/300',
          link: '#feature2'
        },
        {
          title: 'Feature 3',
          description: 'Description for feature 3.',
          image: 'https://via.placeholder.com/300',
          link: '#feature3'
        }
      ]
    };
  }
};
</script>

<style scoped>
/* Global Styles */
body {
  font-family: 'Arial', sans-serif;
  margin: 0;
  padding: 0;
  background-color: #f4f7fa;
}

h1, h2, h3 {
  margin: 0;
  padding: 0;
  color: #333;
}

/* Header Section */
.home-header {
  background-color: #333;
  color: white;
  padding: 40px 20px;
  text-align: center;
}

.home-header h1 {
  font-size: 36px;
  font-weight: 700;
}

.home-header p {
  font-size: 18px;
  margin-top: 10px;
}

/* Main Content Section */
.main-content {
  padding: 50px 20px;
  text-align: center;
}

.main-content h2 {
  font-size: 28px;
  color: #333;
  margin-bottom: 30px;
}

.card-container {
  display: flex;
  justify-content: center;
  gap: 20px;
  flex-wrap: wrap;
}

.card {
  background-color: white;
  border-radius: 10px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
  width: 300px;
  padding: 20px;
  text-align: center;
  transition: transform 0.3s ease;
}

.card:hover {
  transform: translateY(-10px);
}

.card-image {
  width: 100%;
  height: 200px;
  object-fit: cover;
  border-radius: 10px;
}

.card h3 {
  font-size: 22px;
  margin-top: 15px;
  color: #333;
}

.card p {
  font-size: 16px;
  color: #666;
  margin: 10px 0;
}

.card .btn {
  display: inline-block;
  padding: 10px 20px;
  background-color: #007BFF;
  color: white;
  text-decoration: none;
  border-radius: 5px;
  margin-top: 15px;
}

.card .btn:hover {
  background-color: #0056b3;
}

/* Footer Section */
.home-footer {
  background-color: #333;
  color: white;
  padding: 20px;
  text-align: center;
}

.home-footer p {
  font-size: 16px;
}

/* Mobile Responsiveness */
@media (max-width: 768px) {
  .card-container {
    flex-direction: column;
    align-items: center;
  }
}
</style>