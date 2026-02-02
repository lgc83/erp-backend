package port.sm.erp.dto;

import port.sm.erp.entity.Estimate;
import port.sm.erp.entity.EstimateLine;

import java.time.LocalDate;
import java.util.List;

public class EstimateRequest {
    private String estimateNo;
    private LocalDate estimateDate;
    private String custormerName;
    private String remark;
    private List<EstimateLineRequest> line;
}
