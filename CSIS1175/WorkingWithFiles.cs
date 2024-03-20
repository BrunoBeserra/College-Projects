using System.IO;
namespace FileStreams
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string fileLine;
            string[] words;
            int sum = 0;
            int charSum = 0;
            // Step 1 - Open the File
            FileStream fs = new FileStream("input.txt", FileMode.Open, FileAccess.Read);
            StreamReader inText = new StreamReader(fs);

            FileStream fs0ut = new FileStream("output.txt", FileMode.Create, FileAccess.Write);
            StreamWriter outTxt = new StreamWriter(fs0ut);


            // Step 2 - Process the File
            while (!inText.EndOfStream)
            {
                charSum = 0;
                fileLine = inText.ReadLine();
                words = fileLine.Split(' ');
                sum += words.Length;
                for (int i = 0; i < words.Length; i++)
                {
                    charSum += words[i].Length;
                }
                Console.WriteLine(fileLine + $" ({words.Length} words, {charSum} characters)");
                outTxt.WriteLine(fileLine + $" ({words.Length} words, {charSum} characters)");
            }
                Console.WriteLine(sum + $" words)");
            
            Console.ReadKey();
            // Step 3 - Close the File
            inText.Close();
            outTxt.Close();
        }
    }
}