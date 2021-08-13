package xtrn.data.clet.btch.jobs.biz.biz001m.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@JsonIgnoreProperties
public class Biz001mVO {

    private String industNm;
    private String rceptInsttEmailAdres;
    private int inqireCo;
    private String pblancUrl;
    private String jrsdInsttNm;
    private String rceptEngnNm;
    private String entrprsStle;
    private String pldirSportRealmLclasCodeNm;
    private String trgetNm;
    private String rceptInsttTelno;
    private String bsnsSumryCn;
    private String reqstBeginEndDe;
    private String areaNm;
    private String pldirSportRealmMlsfcCodeNm;
    private String rceptInsttChargerDeptNm;
    private String pblancNm;
    private String creatPnttm;
    private String pblancId;

    List<Biz001mVO> jsonArray = new ArrayList<>();

}
