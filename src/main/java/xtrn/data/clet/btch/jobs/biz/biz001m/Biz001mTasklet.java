package xtrn.data.clet.btch.jobs.biz.biz001m;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import xtrn.data.clet.btch.jobs.biz.biz001m.vo.Biz001mVO;

/**
 * 중소기업연구원 중소벤처기업부 기업마당 최신공고 수집
 */
@Slf4j
public class Biz001mTasklet implements Tasklet {

    @Value("${api.biz.url}")
    private String url;

    @Value("${api.biz.crtfcKey}")
    private String crtfcKey;

    @Value("${api.biz.dataType}")
    private String dataType;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

        log.info("START >>>> {}" ,this.getClass().getName());

        log.info("url >>> {}", this.url);
        log.info("ctrfcKey >>> {}", crtfcKey);
        log.info("dataType >>> {}", dataType);

        String url = "https://www.bizinfo.go.kr/uss/rss/bizinfoApi.do";
        String crtfcKey = "k9mn7X";
        String dataType = "json";
//        String uri = url + "?crtfcKey="+crtfcKey+"&dataType="+ dataType;

        // UriComponentsBuilder 를 이용하여 url 링크 생성
        UriComponentsBuilder uri = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("crtfcKey", crtfcKey)
                .queryParam("dataType", dataType);

        log.info("uri >> {}", uri.toUriString());

        // RestTemplate을 이용하여 결과 저장
        RestTemplate restTemplate = new RestTemplate();
        Biz001mVO resultList = restTemplate.getForObject(uri.toUriString(), Biz001mVO.class);

        log.info("resultList.size() >> {}", resultList.getJsonArray().size());

        // 수집 파일 생성


//        for (Biz001mVO resultVO : resultList.getJsonArray()) {
//            log.info("jsonArray.toString() >> {}", resultVO.toString());
//        }

        log.info("END >>>> {}" ,this.getClass().getName());

        return RepeatStatus.FINISHED;
    }
}
