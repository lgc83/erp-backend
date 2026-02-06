package port.sm.erp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/*Journal의 자식(상세) 엔티티입니다.
전표 1건
├─ 차변 | 현금 | 1,000,000
└─ 대변 | 매출 | 1,000,000
* */

@Entity //DB에 저장되는 객체
@Table(name = "JOURNAL_LINES")
@Getter
@Setter
public class JournalLine {

    @Id //기본키(PK) – 전표 라인 번호
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "journal_line_seq")
    @SequenceGenerator(
            name = "journal_line_seq",
            sequenceName = "SEQ_JOURNAL_LINE",
            allocationSize = 1
    )
    private Long id;

    //계정과목과 코드  & 이름
    @Column(name = "ACCOUNT_CODE", nullable = false, length = 20)
    private String accountCode; //101. 401

    @Column(name = "ACCOUNT_NAME", length = 100)
    private String accountName; //현금, 매출

    //차변 DEBIT / 대변 CREDIT - Enum
    @Enumerated(EnumType.STRING)
    @Column(name = "DC_TYPE", nullable = false, length = 10)
    private DcType dcType;

    //금액 전표라인의 금액 정수기반(원단위) 소수점 오류 방지
    @Column(name = "AMOUNT", nullable = false)
    private Long amount;

    /**적요*/
    @Column(name = "LINE_REMARK", length = 500)
    private String lineRemark;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JOURNAL_ID") //👉 외래키(FK) 컬럼
    private Journal journal;

    //전표와의 관계 (핵심)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TRADE_ID", nullable = true) //👉 외래키(FK) 컬럼
    private Trade trade;





}