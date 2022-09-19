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
            var calcul = Calcul.Compute(6,7,'+');

            // Act


            // Assert
            Assert.Equal(13,calcul);
        }
    }
}
