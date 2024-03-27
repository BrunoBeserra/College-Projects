using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp1
{
    public partial class frmMain : Form
    {
        public frmMain()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }

        private void lblResult_Click(object sender, EventArgs e)
        {

        }

        private void sumButton_Click(object sender, EventArgs e)
        {
            double result, firstNumber, secondNumber;

            double.TryParse(txtBox1.Text, out firstNumber);
            double.TryParse(txtBox2.Text, out secondNumber);

            result = firstNumber + secondNumber;
            lblResult.Text = result.ToString();
        }
    }
}
