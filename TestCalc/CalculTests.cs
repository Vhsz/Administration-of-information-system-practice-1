﻿using Calc;
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
            var calcul = Calcul.Compute(6, 7, '+');
            // Assert
            Assert.Equal(13,calcul);
          
        }

        [Fact]
        public void TestMethod4()
        {
            var calcul3 = Calcul.Compute(8, 8, '/');
            Assert.Equal(1, calcul3);
        }
    }
}
