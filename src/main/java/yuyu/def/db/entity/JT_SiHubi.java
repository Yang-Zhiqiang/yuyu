package yuyu.def.db.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

import yuyu.def.db.mapping.GenJT_SiHubi;
import yuyu.def.siharai.predicate.FilterSiHubiDetailByHasinymd;
import yuyu.def.siharai.predicate.FilterSiHubiDetailByHasinymdNotNullKaisyouymdNotNull;
import yuyu.def.siharai.predicate.FilterSiHubiDetailByHasinymdNotNullKaisyouymdNull;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;


/**
 * 支払不備テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_SiHubi} の JavaDoc を参照してください。<br />
 * @see     GenJT_SiHubi<br />
 * @see     PKJT_SiHubi<br />
 * @see     QJT_SiHubi<br />
 * @see     GenQJT_SiHubi<br />
 */
@Entity
public class JT_SiHubi extends GenJT_SiHubi {

    private static final long serialVersionUID = 1L;

    public JT_SiHubi() {
    }

    public JT_SiHubi(String pHubisikibetukey) {
        super(pHubisikibetukey);
    }



    private List<JT_SiHubiDetail> jT_SiHubiDetails = Lists.newLinkedList();
    public JT_SiHubiDetail createSiHubiDetail() {
        JT_SiHubiDetail siHubiDetail =  new JT_SiHubiDetail();
        siHubiDetail.setSiHubi(this);
        siHubiDetail.setHubisikibetukey(this.getHubisikibetukey());
        getSiHubiDetails().add(siHubiDetail);
        return siHubiDetail;
    }
    public void setSiHubiDetails(List<JT_SiHubiDetail> pJT_SiHubiDetails) {
        this.jT_SiHubiDetails = pJT_SiHubiDetails;
    }
    @OneToMany (
        mappedBy = "siHubi",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(JT_SiHubiDetail.HUBISIKIBETUKEY+" ASC ,"+JT_SiHubiDetail.RENNO3KETA+" ASC ")
    public  List<JT_SiHubiDetail> getSiHubiDetails() {
        return jT_SiHubiDetails;
    }

    @Transient
    public  List<JT_SiHubiDetail> getSiHubiDetailsByHasinymd() {
        return new ArrayList<JT_SiHubiDetail>(Collections2.filter(getSiHubiDetails(),
            new FilterSiHubiDetailByHasinymd()));
    }
    @Transient
    public  List<JT_SiHubiDetail> getSiHubiDetailsByHasinymdNotNullKaisyouymdNotNull() {
        return new ArrayList<JT_SiHubiDetail>(Collections2.filter(getSiHubiDetails(),
            new FilterSiHubiDetailByHasinymdNotNullKaisyouymdNotNull()));
    }
    @Transient
    public  List<JT_SiHubiDetail> getSiHubiDetailsByHasinymdNotNullKaisyouymdNull() {
        return new ArrayList<JT_SiHubiDetail>(Collections2.filter(getSiHubiDetails(),
            new FilterSiHubiDetailByHasinymdNotNullKaisyouymdNull()));
    }
}

