# FutureTask

Callables and Future


The FiutureTask is "A cancellable asynchronous computation. This class provides a base implementation of Future, with methods to start and cancel a computation, query to see if the computation is complete, and retrieve the result of the computation."


Callables are just like Runnables to define the smallest unit of work called tasks. The difference between Callable and Runnable is that Runnable cannot return any result whereas Callable can return result of type Future. Later we can get the data from this return value.


Once we submit the Callable task to the Executor, it does not block and returns immediately. We can determine if the task is finished or not by using the isDone api. Once isDone returns TRUE, we can access the result from the future which was returned from submitting the task to the executor using the future.get() API. However, we must remember that get API is blocking and hence if the task is not completed when the get has been called, it will block the thread.


ExecutorService


Actually FutureTask is designed to be used through the ExecutorService interface and the classes that implement it. It is those classes that use FutureTask and fork the threads and create non-blocking Asynchronous background task. Executors typically manage a pool of threads so that we don't have to create threads manually. All the threads in a thread-pool can be reused.


The source code is a working example of the use of FutureTask alongwith Executor model of the Java Concurrency Framework. The basic motto of the Application is the following.


Suppose we need to do a very time consuming task at any time of an Application. Ay reading a big chunk of  data from a huge database. So the basic idea is that whenever the application starts we spawn a background thread through the executor framework and delegate the task of reading data to that background thread. While reading of the data is going on, we continue with our other task in the application. The background thread collects the data and keep it in the future variable which is returned when we submit the task to the executor service. Any time of the application lifecycle we can know if the task is completed or not by calling the api isDone() on the future returned from submitting the task. Then in later time we can access the already fetched data by using the get() api on the future variable which was returned when the task was submitted to the executor framework. Not only that, when the task is going on in the background we can cancel it at anytime we want.
