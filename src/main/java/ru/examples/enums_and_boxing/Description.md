В простейшей форме перечисление представляет собой список именованных констант.
Идентификаторы Jonathan, GoldenDel и так далее называются констаинтами перечисялемого типа.
Каждая из них явно объявлена как открытый статический конечный член класса.
Но, несмотря на то, что перечисления определяют тип класса, получать экземпляры класса типа enum с помощью оператора new нельзя.
Две константы перечислимого типа можно проверять на равенство с помощью операции отношения ==
Перечисления автоматически включают в себя два предопределенных метода: values ( ) и valueOf ()
Метод values () возвращает массив, содержащий список констант перечислимого типа
А метод valueOf ( ) возвращает константу перечислимого типа, значение которой соответствует символьной строке, переданной 
в качестве аргумента строка
аргументы конструктору передаются в скобках после каждой перечисляемой константы, как показано ниже.
Jonathan (lO) , GoldenDel (9) , RedDel (12) , Winesap (15) , Cortland (B) ;

Однако на перечисления накладываются два ограничения. Во-первых, перечисление не может наследоваться от другого класса. 
И во-вторых, перечисление не может быть суперклассом.

Все перечисления автоматически наследуют от класса java.lang.Enum.

ordinal () - можно получить значение, которое обозначает позицию константы в списке констант перечислимого типа
compareTo () - можно сравнить порядковые значения двух констант одного и того же перечислимого типа

Вызвав метод equals (), переопределяющий аналогичный метод из класса Object, можно сравнить на равенство константу 
перечислимого типа с любым другим объектом
Несмотря на то что метод equals() позволяет сравнивать константу перечислимого типа с любым другим объектом, оба эти 
объекта будут равны только в том случае, если они ссылаются на одну и ту же константу из одного и того же перечисления

Оболочки типов представляют собой классы, заключающие примитивный тип данных в оболочку объекта.
К оболочкам типов относятся классы Double, Float, Long, Integer, Short, Byte, Character и Boolean
Оболочки числовых типов  Byte, Short, Integer, Long, Float и DouЫe. Все оболочки числовых типов наследуют абстрактный 
класс Number
упаковка    - Integer iOb = new Integer (100) 
распаковка  - int i = iOb.intValue ();

Автоупаковка - это процесс, в результате которого примитивный тип автоматически инкапсулируется (упаковывается) в 
эквивалентную ему оболочку типа всякий раз, когда требуется объект данного типа.

Автораспаковка - это процесс автоматического извлечения значения упакованного объекта (распаковки) из оболочки типа,
когда нужно получить его значение.

Integer iOb = 100 ;     // автоупаковка значения типа int
int i = iOb;            // автораспаковка

Помимо простых случаев присваивания, автоупаковка происходит автоматически всякий раз, когда примитивный тип должен быть 
преобразован в объект.
Автораспаковка происходит всякий раз, когда объект должен быть преобразован в примитивный тип. 
Таким образом, автоупаковка и автораспаковка может производиться, когда аргумент передается методу или значение 
возвращается из метода.