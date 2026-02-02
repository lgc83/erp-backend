package port.sm.erp.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ESTIMATES")
public class Estimate {

    @Id //견적서 번호가 아니라 DB용 고유id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estimate_seq")
    @SequenceGenerator(
name = "estimate_seq", sequenceName = "SEQ_ESTIMATE", allocationSize = 1
    )
    private Long id;

    @Column(nullable = false) //반드시 값이 있어야 함
    private String estimateNo; //사람이 보는 견적서 번호
    private LocalDate estimateDate;

    @Column(nullable = false)
    private String customerName; //견적 대상 고객이름
    private String remark; //견적서 하단에 메모 같은 용도

    //견적서에 견적서 항목
    @OneToMany(mappedBy = "estimate", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EstimateLine> lines = new ArrayList<>();
}
