import static spark.Spark.*;

public class Calculator {
    public static void main(String[] args) {
        // Set the web server port
        port(8080);

        // Serve the UI (HTML) on the home page
        get("/", (req, res) -> getHtmlTemplate("0"));

        // Handle the calculation requests
        post("/calculate", (req, res) -> {
            String num1Str = req.queryParams("num1");
            String num2Str = req.queryParams("num2");
            String operator = req.queryParams("operator");
            
            try {
                double num1 = Double.parseDouble(num1Str);
                double num2 = Double.parseDouble(num2Str);
                double result = 0;

                switch (operator) {
                    case "add": result = num1 + num2; break;
                    case "subtract": result = num1 - num2; break;
                    case "multiply": result = num1 * num2; break;
                    case "divide": 
                        if (num2 == 0) return getHtmlTemplate("Error: Division by 0");
                        result = num1 / num2; 
                        break;
                }
                
                // Format result to remove trailing decimals if it's a whole number
                String resultStr = (result % 1 == 0) ? String.valueOf((int)result) : String.valueOf(result);
                return getHtmlTemplate(resultStr);
                
            } catch (Exception e) {
                return getHtmlTemplate("Error: Invalid Input");
            }
        });
    }

    // A helper function to return the beautiful HTML + CSS code
    private static String getHtmlTemplate(String result) {
        return "<!DOCTYPE html>" +
               "<html>" +
               "<head>" +
               "    <title>Beautiful Java Calculator</title>" +
               "    <style>" +
               "        body { font-family: 'Segoe UI', Arial, sans-serif; background: linear-gradient(135deg, #74b9ff, #a29bfe); height: 100vh; display: flex; justify-content: center; align-items: center; margin: 0; }" +
               "        .calculator { background: white; padding: 30px; border-radius: 20px; box-shadow: 0 10px 25px rgba(0,0,0,0.15); width: 320px; }" +
               "        h2 { text-align: center; color: #2d3436; margin-top: 0; }" +
               "        .display { background: #dfe6e9; padding: 15px; font-size: 24px; text-align: right; border-radius: 10px; margin-bottom: 20px; font-weight: bold; color: #2d3436; overflow-x: auto; }" +
               "        input, select { width: 100%; padding: 12px; margin: 8px 0; border: 1px solid #ccc; border-radius: 8px; box-sizing: border-box; font-size: 16px; }" +
               "        button { width: 100%; background: #6c5ce7; color: white; padding: 14px; border: none; border-radius: 8px; font-size: 18px; cursor: pointer; font-weight: bold; transition: 0.2s; margin-top: 10px; }" +
               "        button:hover { background: #5b4cc4; }" +
               "    </style>" +
               "</head>" +
               "<body>" +
               "    <div class='calculator'>" +
               "        <h2>Java Calculator</h2>" +
               "        <div class='display'>" + result + "</div>" +
               "        <form action='/calculate' method='post'>" +
               "            <input type='number' step='any' name='num1' placeholder='First Number' required>" +
               "            <select name='operator'>" +
               "                <option value='add'>+ (Add)</option>" +
               "                <option value='subtract'>- (Subtract)</option>" +
               "                <option value='multiply'>&times; (Multiply)</option>" +
               "                <option value='divide'>&divide; (Divide)</option>" +
               "            </select>" +
               "            <input type='number' step='any' name='num2' placeholder='Second Number' required>" +
               "            <button type='submit'>Calculate</button>" +
               "        </form>" +
               "    </div>" +
               "</body>" +
               "</html>";
    }
}
