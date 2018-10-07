import io.prometheus.client.Counter;
import io.prometheus.client.Gauge;
import io.prometheus.client.Histogram;
import io.prometheus.client.Summary;
import io.prometheus.client.vertx.MetricsHandler;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

import java.util.Timer;
import java.util.TimerTask;
//import io.prometheus.client.vertx.MetricsHandler;

public class ExampleExporter {

    static final Gauge g = Gauge.build().name("gauge").help("blah").register();
    static final Counter c = Counter.build().name("counter").help("meh").register();
    static final Summary s = Summary.build().name("summary").help("meh").register();
    static final Histogram h = Histogram.build().name("histogram").help("meh").register();
    static final Gauge l = Gauge.build().name("labels").help("blah").labelNames("l").register();

    public static  void main1(String[] args) throws Exception {




    }


    public static void main(String[] args) {
        final Timer time = new Timer();
        final Vertx vertx = Vertx.vertx();
        final Router router = Router.router(vertx);

        router.route("/metrics").handler(new MetricsHandler());

        vertx.createHttpServer().requestHandler(router::accept).listen(8001);

        time.schedule(new TimerTask() {
            int i = 0;
            @Override
            public void run() { //ПЕРЕЗАГРУЖАЕМ МЕТОД RUN В КОТОРОМ ДЕЛАЕТЕ ТО ЧТО ВАМ НАДО
                //                g.set(1);
//                c.inc(2);
//                s.observe(3);
//                h.observe(4);
//                l.labels("port").inc(10010);
//                l.labels("number").inc(12345);


                if(i>=21){
                    System.out.println("Timer is over");
                    vertx.close();
                    time.cancel();
                    return;

                }
                l.labels("foo").inc(Math.random()*3 );

                System.out.println("4 second ago");
                i = i + 1;
            }
        }, 4000, 4000); //(4000 - ПОДОЖДАТЬ ПЕРЕД НАЧАЛОМ В МИЛИСЕК, ПОВТОРЯТСЯ 4 СЕКУНДЫ (1 СЕК = 1000 МИЛИСЕК))
    }





}
