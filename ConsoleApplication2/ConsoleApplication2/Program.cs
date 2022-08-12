using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace ConsoleApplication2
{
    class Program
    {
        static void Main(string[] args)
        {
            String continuar = "S";
            int i = 0;
            String json;

            while (continuar == "S")
            {

                json =
            "   [\n" +
            "       {\n" +
            "           \"_id\": \"5eb709f204573c1937c118de\",\n" +
            "           \"index\": " + ++i + ",\n" +
            "           \"name\": \"Analisis 2\"\n" +
            "           \"timestamp\": " + DateTime.Now +",\n" +
                "       }\n" +
            "   ]\n";

                Send.Enviar(json);

                Console.WriteLine("Desea enviar otro mensaje [S/N]: ");
                continuar = Console.ReadLine();
            }


            //Send.Recibir();
        }
            
     }
}

