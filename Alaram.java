import software.amazon.awssdk.services.cloudwatch.CloudWatchClient;
import software.amazon.awssdk.services.cloudwatch.model.*;

public class CloudAlarmExample {
    public static void main(String[] args) {

        CloudWatchClient cw = CloudWatchClient.create();

        PutMetricAlarmRequest request = PutMetricAlarmRequest.builder()
                .alarmName("HighCPUAlarm")
                .comparisonOperator(ComparisonOperator.GREATER_THAN_THRESHOLD)
                .evaluationPeriods(1)
                .metricName("CPUUtilization")
                .namespace("AWS/EC2")
                .period(60)
                .threshold(70.0)
                .statistic(Statistic.AVERAGE)
                .alarmDescription("Alarm when CPU exceeds 70%")
                .actionsEnabled(false) // set true if using SNS notifications
                .build();

        cw.putMetricAlarm(request);

        System.out.println("Alarm created successfully!");
        cw.close();
    }
}
