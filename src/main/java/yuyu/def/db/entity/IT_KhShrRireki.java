package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_KhShrRireki;

import com.google.common.collect.Lists;


/**
 * 契約保全支払履歴テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KhShrRireki} の JavaDoc を参照してください。<br />
 * @see     GenIT_KhShrRireki<br />
 * @see     PKIT_KhShrRireki<br />
 * @see     QIT_KhShrRireki<br />
 * @see     GenQIT_KhShrRireki<br />
 */
@Entity
public class IT_KhShrRireki extends GenIT_KhShrRireki {

    private static final long serialVersionUID = 1L;

    public IT_KhShrRireki() {
    }

    public IT_KhShrRireki(String pKbnkey,String pSyono,String pHenkousikibetukey) {
        super(pKbnkey,pSyono,pHenkousikibetukey);
    }

    public IT_KhShrRireki(String pSyono,String pHenkousikibetukey) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pHenkousikibetukey);
    }


    private IT_KhTtdkRireki iT_KhTtdkRireki ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_KhShrRireki.KBNKEY  , referencedColumnName=IT_KhTtdkRireki.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_KhShrRireki.SYONO  , referencedColumnName=IT_KhTtdkRireki.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_KhShrRireki.HENKOUSIKIBETUKEY  , referencedColumnName=IT_KhTtdkRireki.HENKOUSIKIBETUKEY, insertable=false, updatable=false)
    })
    public IT_KhTtdkRireki getKhTtdkRireki() {
        return iT_KhTtdkRireki;
    }

    public void setKhTtdkRireki(IT_KhTtdkRireki pIT_KhTtdkRireki) {
        this.iT_KhTtdkRireki = pIT_KhTtdkRireki;
    }

    private List<IT_KhShrRirekiDetail> iT_KhShrRirekiDetails = Lists.newLinkedList();
    public IT_KhShrRirekiDetail createKhShrRirekiDetail() {
        IT_KhShrRirekiDetail khShrRirekiDetail =  new IT_KhShrRirekiDetail();
        khShrRirekiDetail.setKhShrRireki(this);
        khShrRirekiDetail.setKbnkey(this.getKbnkey());
        khShrRirekiDetail.setSyono(this.getSyono());
        khShrRirekiDetail.setHenkousikibetukey(this.getHenkousikibetukey());
        getKhShrRirekiDetails().add(khShrRirekiDetail);
        return khShrRirekiDetail;
    }
    public void setKhShrRirekiDetails(List<IT_KhShrRirekiDetail> pIT_KhShrRirekiDetails) {
        this.iT_KhShrRirekiDetails = pIT_KhShrRirekiDetails;
    }
    @OneToMany (
        mappedBy = "khShrRireki",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
        @OrderBy(IT_KhShrRirekiDetail.SYONO+" ASC ,"+IT_KhShrRirekiDetail.HENKOUSIKIBETUKEY+" ASC ,"+IT_KhShrRirekiDetail.SYOUHNCD+" ASC ,"+IT_KhShrRirekiDetail.SYOUHNSDNO+" ASC ,"+IT_KhShrRirekiDetail.KYKSYOUHNRENNO+" ASC ")
    public  List<IT_KhShrRirekiDetail> getKhShrRirekiDetails() {
        return iT_KhShrRirekiDetails;
    }

}

