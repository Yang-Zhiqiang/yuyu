package yuyu.def.db.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.db.mapping.GenIT_KhHubi;
import yuyu.def.hozen.predicate.FilterKhHubiDetailByHasinymd;
import yuyu.def.hozen.predicate.FilterKhHubiDetailByRenno3keta;
import yuyu.def.hozen.predicate.FilterKhHubiDetailsByHasinymdHassinsakikbn;
import yuyu.def.hozen.predicate.FilterKhHubiDetailsByHasinymdKaisyouymdNotNull;
import yuyu.def.hozen.predicate.FilterKhHubiDetailsByHasinymdKaisyouymdNull;

import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;


/**
 * 契約保全不備テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KhHubi} の JavaDoc を参照してください。<br />
 * @see     GenIT_KhHubi<br />
 * @see     PKIT_KhHubi<br />
 * @see     QIT_KhHubi<br />
 * @see     GenQIT_KhHubi<br />
 */
@Entity
public class IT_KhHubi extends GenIT_KhHubi {

    private static final long serialVersionUID = 1L;

    public IT_KhHubi() {
    }

    public IT_KhHubi(String pHubisikibetukey) {
        super(pHubisikibetukey);
    }



    private List<IT_KhHubiDetail> iT_KhHubiDetails = Lists.newLinkedList();
    public IT_KhHubiDetail createKhHubiDetail() {
        IT_KhHubiDetail khHubiDetail =  new IT_KhHubiDetail();
        khHubiDetail.setKhHubi(this);
        khHubiDetail.setHubisikibetukey(this.getHubisikibetukey());
        getKhHubiDetails().add(khHubiDetail);
        return khHubiDetail;
    }
    public void setKhHubiDetails(List<IT_KhHubiDetail> pIT_KhHubiDetails) {
        this.iT_KhHubiDetails = pIT_KhHubiDetails;
    }
    @OneToMany (
            mappedBy = "khHubi",
            cascade = { CascadeType.ALL },
            orphanRemoval = true
            )
    @OrderBy(IT_KhHubiDetail.HUBISIKIBETUKEY+" ASC ,"+IT_KhHubiDetail.RENNO3KETA+" ASC ")
    public  List<IT_KhHubiDetail> getKhHubiDetails() {
        return iT_KhHubiDetails;
    }

    @Transient
    public  IT_KhHubiDetail getKhHubiDetailByRenno3keta(Integer pRenno3keta) {
        return Iterables.getFirst(Iterables.filter(getKhHubiDetails(),
                new FilterKhHubiDetailByRenno3keta(pRenno3keta)),null);
    }
    @Transient
    public  List<IT_KhHubiDetail> getKhHubiDetailsByHasinymdHassinsakikbn(BizDate pHasinymd,C_HassinsakiKbn pHassinsakikbn) {
        return new ArrayList<IT_KhHubiDetail>(Collections2.filter(getKhHubiDetails(),
                new FilterKhHubiDetailsByHasinymdHassinsakikbn(pHasinymd,pHassinsakikbn)));
    }
    @Transient
    public  List<IT_KhHubiDetail> getKhHubiDetailsByHasinymd() {
        return new ArrayList<IT_KhHubiDetail>(Collections2.filter(getKhHubiDetails(),
                new FilterKhHubiDetailByHasinymd()));
    }
    @Transient
    public  List<IT_KhHubiDetail> getKhHubiDetailsByHasinymdKaisyouymdNull() {
        return new ArrayList<IT_KhHubiDetail>(Collections2.filter(getKhHubiDetails(),
                new FilterKhHubiDetailsByHasinymdKaisyouymdNull()));
    }
    @Transient
    public  List<IT_KhHubiDetail> getKhHubiDetailsByHasinymdKaisyouymdNotNull() {
        return new ArrayList<IT_KhHubiDetail>(Collections2.filter(getKhHubiDetails(), new FilterKhHubiDetailsByHasinymdKaisyouymdNotNull()));
    }
}

