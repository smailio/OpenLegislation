package gov.nysenate.openleg.dao.spotcheck;

import com.google.common.collect.Sets;
import gov.nysenate.openleg.BaseTests;
import gov.nysenate.openleg.model.bill.BillId;
import gov.nysenate.openleg.model.spotcheck.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Transactional
public class SpotCheckReportDaoTests extends BaseTests {

    @Autowired
    private BaseBillIdSpotCheckReportDao reportDao;

    @Test
    public void updatableMismatches() {
        MismatchQuery query = new MismatchQuery(SpotCheckDataSource.LBDC, Sets.newHashSet(SpotCheckContentType.BILL));
        System.out.println(reportDao.getUpdatableMismatches(query).size());
    }

    @Test
    public void save() {
        LocalDateTime refDateTime = LocalDateTime.now();
        SpotCheckReport report = new SpotCheckReport();
        SpotCheckReportId reportId = new SpotCheckReportId(SpotCheckRefType.LBDC_DAYBREAK, refDateTime, LocalDateTime.now());
        report.setReportId(reportId);
        SpotCheckObservation ob = new SpotCheckObservation(new SpotCheckReferenceId(SpotCheckRefType.LBDC_DAYBREAK, refDateTime), new BillId("A1029", 2017));
        report.addObservation(ob);
        reportDao.saveReport(report);
    }

}
