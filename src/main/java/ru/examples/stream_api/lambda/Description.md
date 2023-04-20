Лямбда-выражение, по существу, является анонимным (т.е. безымянным) методом. Но этот метод не выполняется самостоятельно, 
а служит для реализации метода, определяемого в функциональном интерфейсе. Таким образом, лямбда-выражение приводит к 
некоторой форме анонимного класса. Нередко лямбда-выражения называют также замыканиями. 

Функционалъным называется такой интерфейс, который содержит один и только один абстрактный метод. Как правило, в таком 
методе определяется предполагаемое назначение интерфейса. Следовательно, функциональный интерфейс предсгамяет 
единственное действие. Кроме того, в функциональном интерфейсе определяется целевой тип лямбда-выражения. В связи с этим 
необходимо подчеркнуть следующее: лямбда-выражение можно использовать только в том контексте, в котором определен его 
целевой тип. И еще одно замечание: функциональный интерфейс иногда еще называют SАМ-типом, где SАМ обозначает 
Single Abstract Method - единственный абстрактный метод.

В Java определены две разновидности тел лямбда-выражений. Одна из них состоит из единственного выражения, а другая - из 
блока кода

1) Тело лямбда-выражений в предыдущих примерах состояло из единственного выражения. Такая разновидность тел называется 
телом выражения, а лямбда-выражения с телом выражения иногда еще называют одиночными.

() -> 123.45   -  double myMeth () {return 123.45;}
() -> Math.random() * 100
(n) -> (n % 2)==0

2) Несмотря на все удобство одиночных лямбда-выражений, иногда в них требуется вычислять не одно выражение. Для 
подобныхслучаев в Java предусмотрена вторая разновидность лямбда-выражений, где код, указываемый в правой части 
лямбда-оператора, может состоять из нескольких операторов. Такие лямбда-выражения называются блочными, а их тело - телом блака. 

Обобщенные функциональные интерфейсы

Указывать параметры типа в самом лямбда-выражении нельзя. Следовательно, лямбда-выражение не может быть обобщенным. 
(Безусловно, все лямбда-выражения проявляют в той или иной мере свойства, подобные обобщениям, благодаря выведению 
типов.) А вот функциональный интерфейс, связанный с лямбда-выражением, может быть обобщенным. В этом случае целевой тип 
лямбда-выражения отчасти определяется аргументом типа или теми аргументами, которые указываются при объявлении ссылки 
на функциональный интерфейс.

interface someFunc<T> {
T func(T t);
}

Передача лямбда-выражений в качестве аргументов
Как пояснялось ранее, лямбда-выражение может быть использовано в любом контексте, предоставляющем его целевой тип. Один 
из таких контекстов возникает при передаче лямбда-выражения в качестве аргумента.