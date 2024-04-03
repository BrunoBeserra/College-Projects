using System;
namespace RainFall
{
    
    internal class MonthRainFall
    {
        public string MonthName { get; set; }
        public float RainFall {  get; set; }
    }
    internal class Program
    {
        static void Main(string[] args)
        {
            const int MONTH_COUNT = 6;
            float avgRainFall;
            double rainFallVariance;
            MonthRainFall[] rainFalls = new MonthRainFall[MONTH_COUNT];
            GetRainFalls(rainFalls);
            avgRainFall = CalcAverage(rainFalls);
            rainFallVariance = CalcVariance(rainFalls, avgRainFall);
        }
        static void GetRainFalls(MonthRainFall[] rainFalls)
        {
            const int MAX_RAINFALL = 1000;
            string userInput;
            float userValue;

            for (int month = 0; month < rainFalls.Length; month++)
            {
                MonthRainFall mRainFall = new MonthRainFall();
                do
                {
                    Console.WriteLine("Enter Month Name: ");
                    userInput = Console.ReadLine();
                    if (mRainFall.MonthName.Length <= 3 || mRainFall.MonthName.Length => 9)
                    {
                        Console.WriteLine("Enter Month Name: ");
                    }
                } while (mRainFall.MonthName.Length < 3 || mRainFall.MonthName.Length > 9);

                do
                {
                    Console.WriteLine($"Enter Rain Fall for {mRainFall.MonthName}: ");
                    userInput = Console.ReadLine();
                    if (float.TryParse(userInput, out userValue))
                    {
                        if (userValue < 0 || userValue > MAX_RAINFALL)
                        {
                            Console.WriteLine($"The value must be between 0 and {MAX_RAINFALL}");
                        }
                        mRainFall.RainFall = userValue;
                    }
                    else
                    {
                        Console.WriteLine("Enter a numeric value.");
                    }
                } while (userValue < 0 || userValue > MAX_RAINFALL);
                rainFalls[month] = mRainFall;
            }

        }

        static float CalcAverage(MonthRainFall[] rainFalls)
        {
            float sum = 0;
            foreach (MonthRainFall mrf in rainFalls)
            {
                sum += mrf.RainFall;
            }
            return (sum / rainFalls.Length);
        }

        static double CalcVariance(MonthRainFall[] rainFalls, float avg)
        {
            double sum = 0;
            foreach (MonthRainFall mrf in rainFalls)
            {
                sum += Math.Pow(mrf.RainFall - avg, 2);
            }
            return (sum / (rainFalls.Length - 1));
        }

        static void DisplayRainFallStat(MonthRainFall[] rainFalls, float avg, double variance)
        {
            for (int month = 0; month< rainFalls.Length; month++)
            {
                Console.Write($"{rainFalls[month].MonthName, -10}");
            }
            Console.WriteLine();
            for (int month = 0; month < rainFalls.Length; month++)
            {
                Console.WriteLine("----------");
            }
            Console.WriteLine();
            foreach (MonthRainFall mrf in rainFalls)
            {
                Console.Write($"{mrf.RainFall,-10}");
            }
            Console.WriteLine();

            Console.WriteLine($"The average rainfall is {avg:F2}.");
            Console.WriteLine($"The variance of rainfalls is {variance:F2}.");

        }
    }
}