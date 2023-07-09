CREATE TABLE IT_DrtenMinyuKykNaiyou (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     syoriym                                            VARCHAR     (6)                                                       NOT NULL  ,  /* 処理年月 */
     keiyakuymd                                         VARCHAR     (8)                                                                 ,  /* 契約年月日 */
     bosyuuym                                           VARCHAR     (6)                                                                 ,  /* 募集年月 */
     hrkkaisuu                                          VARCHAR     (2)                                                                 ,  /* 払込回数 */
     hrkkeiro                                           VARCHAR     (2)                                                                 ,  /* 払込経路 */
     syuukeikbn                                         VARCHAR     (1)                                                                 ,  /* 集計区分 */
     minyukaisuu                                        NUMBER      (3)                                                                 ,  /* 未入回数 */
     hrkp                                               NUMBER      (13)                                                                ,  /* 払込保険料 */
     hrkp$                                              VARCHAR     (10)                                                                ,  /* 払込保険料(通貨型) */
     hsys                                               NUMBER      (13)                                                                ,  /* 保障Ｓ */
     hsys$                                              VARCHAR     (10)                                                                ,  /* 保障Ｓ(通貨型) */
     syuuseis                                           NUMBER      (13)                                                                ,  /* 修正Ｓ */
     syuuseis$                                          VARCHAR     (10)                                                                ,  /* 修正Ｓ(通貨型) */
     hukkatutyuuikbn                                    VARCHAR     (1)                                                                 ,  /* 復活注意区分 */
     mrarihyj                                           VARCHAR     (1)                                                                 ,  /* ＭＲ有表示 */
     fstttkekykhyj                                      VARCHAR     (1)                                                                 ,  /* 初回立替契約表示 */
     ttkernzkkaisuu                                     NUMBER      (2)                                                                 ,  /* 立替計上連続回数 */
     keizokutyuuihyj                                    VARCHAR     (1)                                                                 ,  /* 継続注意表示 */
     syouhinbunruikbn                                   VARCHAR     (1)                                                                 ,  /* 商品分類区分 */
     syouhnnmkbn                                        VARCHAR     (2)                                                                 ,  /* 商品名称区分 */
     hknsyukigou                                        VARCHAR     (2)                                                                 ,  /* 保険種類記号 */
     jkipjytym                                          VARCHAR     (6)                                                                 ,  /* 次回Ｐ充当年月 */
     hurihunokbn                                        VARCHAR     (1)                                                                 ,  /* 振替不能理由区分 */
     autocallkykhyj                                     VARCHAR     (1)                                                                 ,  /* オートコール対象契約表示 */
     bosyuudairitenatkikeitaikbn                        VARCHAR     (1)                                                                 ,  /* 募集代理店扱形態区分 */
     dairitencd1                                        VARCHAR     (7)                                                                 ,  /* 代理店コード１ */
     dairitencd2                                        VARCHAR     (7)                                                                 ,  /* 代理店コード２ */
     drtenkanrisosikicd1                                VARCHAR     (7)                                                                 ,  /* 代理店管理組織コード１ */
     drtenkanrisosikicd2                                VARCHAR     (7)                                                                 ,  /* 代理店管理組織コード２ */
     drtenchannelsyuruikbn1                             VARCHAR     (2)                                                                 ,  /* 代理店チャネル種類区分１ */
     drtenchannelsyuruikbn2                             VARCHAR     (2)                                                                 ,  /* 代理店チャネル種類区分２ */
     bosyuucd1                                          VARCHAR     (6)                                                                 ,  /* 募集人コード１ */
     bosyuucd2                                          VARCHAR     (6)                                                                 ,  /* 募集人コード２ */
     bosyuuningyouhaiymd1                               VARCHAR     (8)                                                                 ,  /* 募集人業廃年月日１ */
     bosyuuningyouhaiymd2                               VARCHAR     (8)                                                                 ,  /* 募集人業廃年月日２ */
     kydatkikbnkj                                       VARCHAR     (1)                                                                 ,  /* 共同扱区分（漢字） */
     ikkatubaraikbn                                     VARCHAR     (1)                                                                 ,  /* 一括払区分 */
     ikkatubaraikaisuu                                  VARCHAR     (2)                                                                 ,  /* 一括払回数 */
     cifcd                                              VARCHAR     (15)                                                                ,  /* ＣＩＦコード */
     yykknmnryymd                                       VARCHAR     (8)                                                                 ,  /* 猶予期間満了日 */
     kyknm35keta                                        VARCHAR     (35)                                                                ,  /* 契約者名（３５桁） */
     tsinkihontikucd                                    VARCHAR     (8)                                                                 ,  /* 通信先基本地区コード */
     kanjitsinkaiadr                                    VARCHAR     (62)                                                                ,  /* 漢字通信先下位住所 */
     tsintelno                                          VARCHAR     (14)                                                                ,  /* 通信先電話番号 */
     dai2tsintelno                                      VARCHAR     (14)                                                                ,  /* 第２通信先電話番号 */
     hhknnmkj                                           VARCHAR     (15)                                                                ,  /* 被保険者名（漢字） */
     nexthurikaeymd                                     VARCHAR     (8)                                                                 ,  /* 次回振替日 */
     minyusyoriymd                                      VARCHAR     (8)                                                                 ,  /* 未入処理日 */
     jyuutouym                                          VARCHAR     (6)                                                                 ,  /* 充当年月 */
     bankcd                                             VARCHAR     (4)                                                                 ,  /* 銀行コード */
     sitencd                                            VARCHAR     (3)                                                                 ,  /* 支店コード */
     yokinkbn                                           VARCHAR     (1)                                                                 ,  /* 預金種目区分 */
     kouzano                                            VARCHAR     (12)                                                                ,  /* 口座番号 */
     kzmeiginmkn                                        VARCHAR     (30)                                                                ,  /* 口座名義人氏名（カナ） */
     tikiktbrisyuruikbn                                 VARCHAR     (2)                                                                 ,  /* 定期一括払種類区分 */
     jkiannaikg                                         NUMBER      (13)                                                                ,  /* 次回案内金額 */
     jkiannaikg$                                        VARCHAR     (10)                                                                ,  /* 次回案内金額(通貨型) */
     misyuup                                            NUMBER      (13)                                                                ,  /* 未収保険料 */
     misyuup$                                           VARCHAR     (10)                                                                ,  /* 未収保険料(通貨型) */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IT_DrtenMinyuKykNaiyou ADD CONSTRAINT PK_DrtenMinyuKykNaiyou PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     syoriym                                                    /* 処理年月 */
) ;
