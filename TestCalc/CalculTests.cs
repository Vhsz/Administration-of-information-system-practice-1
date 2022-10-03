using Calc;
using System;
using Xunit;

namespace TestCalc
{
    public class CalculTests
    {
        [Fact]
        public void TestMethod1()
        {
            // Arrange
            var calcul = Calcul.Compute(5, 7, '+')
            // Assert
            Assert.Equal(13,calcul);
          
        }

        [Fact]
        public void TestMethod2()
        {
            // Arrange
            var calcul = Calcul.Compute(6, 7, '+');
            var calcul1 = Calcul.Compute(7, 7, '-');
         
            Assert.Equal(13, calcul);
            Assert.Equal(0, calcul1);
          
        }

        [Fact]
        public void TestMethod3()
        {
            var calcul2 = Calcul.Compute(8, 8, '*');
            Assert.Equal(64, calcul2);
        }

        [Fact]
        public void TestMethod4()
        {
            var calcul3 = Calcul.Compute(8, 8, '/');
            Assert.Equal(1, calcul3);
        }
    }
}
