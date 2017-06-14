package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table
@Data
@Getter
@NoArgsConstructor
public class RunningInformation {
    enum HealthWarningLevel{
        LOW,NORMAL,HIGH
    }
    @Id
    private String runningId;
    private double latitude;
    private double longitude;
    private double runningDistance;
    private double totalRunningTime;
    private int heartRate;
    private Date timeStamp;
    @Embedded
    private UserInformation userInformation;
    private HealthWarningLevel healthWarningLevel;

    @JsonCreator
    public RunningInformation(
            @JsonProperty("runningId") String runningId,
            @JsonProperty("latitude") String latitude,
            @JsonProperty("longitude") String longitude,
            @JsonProperty("runningDistance") String runningDistance,
            @JsonProperty("totalRunningTime") String totalRunningTime,
            @JsonProperty("heartRate") int heartRate,
            @JsonProperty("timeStamp") String timeStamp,
            @JsonProperty("user") UserInformation userInformation
    ){
        this.runningId = runningId;
        this.latitude = Double.parseDouble(latitude);
        this.longitude = Double.parseDouble(longitude);
        this.runningDistance = Double.parseDouble(runningDistance);
        this.totalRunningTime = Double.parseDouble(totalRunningTime);

        this.heartRate = getRandHearRate(60,200);
        if (this.heartRate > 120){
            this.healthWarningLevel = HealthWarningLevel.HIGH;
        }else if (this.heartRate >75){
            this.healthWarningLevel = HealthWarningLevel.NORMAL;
        }else if (this.heartRate >= 60){
            this.healthWarningLevel = HealthWarningLevel.LOW;
        }else{
            System.out.print("Warning: Danger Level");
        }

        this.timeStamp = new Date();
        this.userInformation = userInformation;
    }

    private int getRandHearRate(int min, int max){
                Random number = new Random();
                return min+number.nextInt(max-min+1);
    }

    @JsonIgnore
    public String getSimpleJson(){
        class Pair {
            String first;
            String second;

            Pair(String first, String second) {
                this.first = first;
                this.second = second;
            }

        }

        StringBuilder StringB = new StringBuilder();

        List<Pair> info = new LinkedList<Pair>();
        info.add(new Pair("\"" + "runningId" + "\"", "\"" + runningId + "\""));
        info.add(new Pair("\"" + "totalrunningTime" + "\"", Double.toString(totalRunningTime)));
        info.add(new Pair("\"" + "heartrate" + "\"", Integer.toString(heartRate)));
        info.add(new Pair("\"" + "userId" + "\"", Integer.toString(userInformation.getUserId())));
        info.add(new Pair("\"" + "userName" + "\"", "\"" + userInformation.getName()+"\""));
        info.add(new Pair("\"" + "userAddress" + "\"", "\"" +userInformation.getAddress() + "\""));
        info.add(new Pair("\"" + "healthWarningLevel" + "\"", "\"" + healthWarningLevel.toString() + "\""));
        StringB.append('{');

        for(int i = 0; i != info.size(); i++){
            Pair p = info.get(i);
            StringB.append(p.first);
            StringB.append(':');
            StringB.append(p.second);
            if(i != info.size() - 1) StringB.append(',');
        }
        StringB.append('}');
        return StringB.toString();

    }


}
