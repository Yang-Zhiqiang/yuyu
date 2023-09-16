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
import yuyu.def.db.mapping.GenIT_BAK_KhShrRireki;

import com.google.common.collect.Lists;


/**
 * 契約保全支払履歴バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_KhShrRireki} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_KhShrRireki<br />
 * @see     PKIT_BAK_KhShrRireki<br />
 * @see     QIT_BAK_KhShrRireki<br />
 * @see     GenQIT_BAK_KhShrRireki<br />
 */
@Entity
public class IT_BAK_KhShrRireki extends GenIT_BAK_KhShrRireki {

    private static final long serialVersionUID = 1L;

    public IT_BAK_KhShrRireki() {
    }

    public IT_BAK_KhShrRireki(String pKbnkey,String pSyono,String pTrkssikibetukey,String pHenkousikibetukey) {
        super(pKbnkey,pSyono,pTrkssikibetukey,pHenkousikibetukey);
    }

    public IT_BAK_KhShrRireki(String pSyono,String pTrkssikibetukey,String pHenkousikibetukey) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTrkssikibetukey,pHenkousikibetukey);
    }


    private IT_BAK_KhTtdkRireki iT_BAKKhTtdkRireki ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_BAK_KhShrRireki.KBNKEY  , referencedColumnName=IT_BAK_KhTtdkRireki.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_KhShrRireki.SYONO  , referencedColumnName=IT_BAK_KhTtdkRireki.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_KhShrRireki.TRKSSIKIBETUKEY  , referencedColumnName=IT_BAK_KhTtdkRireki.TRKSSIKIBETUKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_KhShrRireki.HENKOUSIKIBETUKEY  , referencedColumnName=IT_BAK_KhTtdkRireki.HENKOUSIKIBETUKEY, insertable=false, updatable=false)
    })
    public IT_BAK_KhTtdkRireki getBAKKhTtdkRireki() {
        return iT_BAKKhTtdkRireki;
    }

    public void setBAKKhTtdkRireki(IT_BAK_KhTtdkRireki pIT_BAK_KhTtdkRireki) {
        this.iT_BAKKhTtdkRireki = pIT_BAK_KhTtdkRireki;
    }

    private List<IT_BAK_KhShrRirekiDetail> iT_BAKKhShrRirekiDetails = Lists.newLinkedList();
    public IT_BAK_KhShrRirekiDetail createBAKKhShrRirekiDetail() {
        IT_BAK_KhShrRirekiDetail bAKKhShrRirekiDetail =  new IT_BAK_KhShrRirekiDetail();
        bAKKhShrRirekiDetail.setBAKKhShrRireki(this);
        bAKKhShrRirekiDetail.setKbnkey(this.getKbnkey());
        bAKKhShrRirekiDetail.setSyono(this.getSyono());
        bAKKhShrRirekiDetail.setTrkssikibetukey(this.getTrkssikibetukey());
        bAKKhShrRirekiDetail.setHenkousikibetukey(this.getHenkousikibetukey());
        getBAKKhShrRirekiDetails().add(bAKKhShrRirekiDetail);
        return bAKKhShrRirekiDetail;
    }
    public void setBAKKhShrRirekiDetails(List<IT_BAK_KhShrRirekiDetail> pIT_BAK_KhShrRirekiDetails) {
        this.iT_BAKKhShrRirekiDetails = pIT_BAK_KhShrRirekiDetails;
    }
    @OneToMany (
        mappedBy = "BAKKhShrRireki",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
        @OrderBy(IT_BAK_KhShrRirekiDetail.SYONO+" ASC ,"+IT_BAK_KhShrRirekiDetail.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_KhShrRirekiDetail.HENKOUSIKIBETUKEY+" ASC ,"+IT_BAK_KhShrRirekiDetail.SYOUHNCD+" ASC ,"+IT_BAK_KhShrRirekiDetail.SYOUHNSDNO+" ASC ,"+IT_BAK_KhShrRirekiDetail.KYKSYOUHNRENNO+" ASC ")
    public  List<IT_BAK_KhShrRirekiDetail> getBAKKhShrRirekiDetails() {
        return iT_BAKKhShrRirekiDetails;
    }

}

