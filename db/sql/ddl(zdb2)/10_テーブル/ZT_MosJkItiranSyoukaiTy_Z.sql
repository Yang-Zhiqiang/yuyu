CREATE TABLE ZT_MosJkItiranSyoukaiTy_Z (
     ztymosym                                           VARCHAR     (6)                                                       NOT NULL  ,  /* （中継用）申込月度 */
     ztymoskbn                                          VARCHAR     (1)                                                                 ,  /* （中継用）申込区分 */
     ztymosno                                           VARCHAR     (9)                                                       NOT NULL  ,  /* （中継用）申込番号 */
     ztyhknsyuruinm                                     VARCHAR     (22)                                                                ,  /* （中継用）保険種類名称 */
     ztykykymd                                          VARCHAR     (8)                                                                 ,  /* （中継用）契約年月日 */
     ztymusymd                                          VARCHAR     (8)                                                                 ,  /* （中継用）申込年月日 */
     ztymosnyuuryokuymd                                 VARCHAR     (8)                                                                 ,  /* （中継用）申込入力年月日 */
     ztykydatkikbn                                      VARCHAR     (1)                                                                 ,  /* （中継用）共同扱区分 */
     ztybsudirtnatkikeitaikbn                           VARCHAR     (1)                                                                 ,  /* （中継用）募集代理店扱形態区分 */
     ztybsydrtencd                                      VARCHAR     (7)                                                       NOT NULL  ,  /* （中継用）募集代理店コード */
     ztybsydrtenkjnm                                    VARCHAR     (32)                                                                ,  /* （中継用）募集代理店漢字名称 */
     ztyatukaikojincd                                   VARCHAR     (6)                                                       NOT NULL  ,  /* （中継用）扱者個人コード */
     ztytansyukukjatukaisyanm                           VARCHAR     (16)                                                                ,  /* （中継用）短縮漢字扱者名 */
     ztycifcd                                           VARCHAR     (15)                                                                ,  /* （中継用）ＣＩＦコード */
     ztykjkyknm10                                       VARCHAR     (22)                                                                ,  /* （中継用）漢字契約者名（１０文字） */
     ztytansyukukjhhknnm                                VARCHAR     (16)                                                                ,  /* （中継用）短縮漢字被保険者名 */
     ztyhhknnen2keta                                    VARCHAR     (2)                                                                 ,  /* （中継用）被保険者年令（２桁） */
     ztyhhknseikbn                                      VARCHAR     (1)                                                                 ,  /* （中継用）被保険者性別区分 */
     ztymossyoumetukbn                                  VARCHAR     (1)                                                                 ,  /* （中継用）申込消滅区分 */
     ztykurikosiriyuukbn                                VARCHAR     (2)                                                                 ,  /* （中継用）繰越理由区分 */
     ztyketjkkbn                                        VARCHAR     (1)                                                                 ,  /* （中継用）決定状況区分 */
     ztydakuhiktjyoutaikbn                              VARCHAR     (2)                                                                 ,  /* （中継用）諾否決定状態区分 */
     ztymosketkekkakbn                                  VARCHAR     (1)                                                                 ,  /* （中継用）申込決定結果区分 */
     ztykihonhubi                                       VARCHAR     (1)                                                                 ,  /* （中継用）基本不備 */
     ztykthhbhyouji                                     VARCHAR     (1)                                                                 ,  /* （中継用）決定保留不備表示 */
     ztysrhhbhyouji                                     VARCHAR     (1)                                                                 ,  /* （中継用）成立保留不備表示 */
     ztynyknzumihyouji                                  VARCHAR     (1)                                                                 ,  /* （中継用）入金済表示 */
     ztysinsazumihyouji                                 VARCHAR     (1)                                                                 ,  /* （中継用）診査済表示 */
     ztytuukatanikbn                                    VARCHAR     (1)                                                                 ,  /* （中継用）通貨単位区分 */
     ztysyokaihrkpmoji                                  VARCHAR     (11)                                                                ,  /* （中継用）初回払込Ｐ（文字列） */
     ztyhjykktkbn                                       VARCHAR     (1)                                                                 ,  /* （中継用）報状告知区分 */
     ztysyokaipryosyuymd                                VARCHAR     (8)                                                                 ,  /* （中継用）初回Ｐ領収年月日 */
     ztykokutiymd                                       VARCHAR     (8)                                                                 ,  /* （中継用）告知年月日 */
     ztykariseirituymd                                  VARCHAR     (8)                                                                 ,  /* （中継用）仮成立年月日 */
     ztyfstpnyknnaiyoukbn                               VARCHAR     (1)                                                                 ,  /* （中継用）初回Ｐ入金内容区分 */
     ztyhknkkn                                          VARCHAR     (2)                                                                 ,  /* （中継用）保険期間 */
     ztyphrkkikn                                        VARCHAR     (2)                                                                 ,  /* （中継用）Ｐ払込期間 */
     ztyhrkkaisuukbn                                    VARCHAR     (1)                                                                 ,  /* （中継用）払込回数区分 */
     ztyhrkkeirokbn                                     VARCHAR     (1)                                                                 ,  /* （中継用）払込経路区分 */
     ztysakuseiymd                                      VARCHAR     (8)                                                                 ,  /* （中継用）作成日 */
     ztyanniskcd                                        VARCHAR     (8)                                                                 ,  /* （中継用）案内先コード */
     ztysyosakuseiymd                                   VARCHAR     (8)                                                                 ,  /* （中継用）証券作成年月日 */
     ztybsydrtenkobetuinfo1                             VARCHAR     (15)                                                                ,  /* （中継用）募集代理店個別情報１ */
     ztybsydrtenkobetuinfo2                             VARCHAR     (15)                                                                ,  /* （中継用）募集代理店個別情報２ */
     ztybsydrtenkobetuinfo3                             VARCHAR     (15)                                                                ,  /* （中継用）募集代理店個別情報３ */
     ztybsydrtenkobetuinfo4                             VARCHAR     (15)                                                                ,  /* （中継用）募集代理店個別情報４ */
     ztybsydrtenkobetuinfo5                             VARCHAR     (15)                                                                ,  /* （中継用）募集代理店個別情報５ */
     ztybankkouincd                                     VARCHAR     (10)                                                                ,  /* （中継用）銀行行員コード */
     ztybosyuutourokuno                                 VARCHAR     (13)                                                                ,  /* （中継用）募集人登録番号 */
     ztymosjkkbn                                        VARCHAR     (1)                                                                 ,  /* （中継用）申込状況区分 */
     ztykousinymd                                       VARCHAR     (8)                                                                 ,  /* （中継用）更新年月日 */
     ztysinsayoteiymd                                   VARCHAR     (8)                                                                 ,  /* （中継用）診査予定年月日 */
     ztyhjnkykhyj                                       VARCHAR     (1)                                                                 ,  /* （中継用）法人契約表示 */
     ztykjhjnnm                                         VARCHAR     (62)                                                                ,  /* （中継用）漢字法人名 */
     ztyyobiv93                                         VARCHAR     (93)                                                                ,  /* （中継用）予備項目Ｖ９３ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE ZT_MosJkItiranSyoukaiTy_Z ADD CONSTRAINT PK_MosJkItiranSyoukaiTy PRIMARY KEY (
     ztymosym                                                 , /* （中継用）申込月度 */
     ztymosno                                                 , /* （中継用）申込番号 */
     ztybsydrtencd                                            , /* （中継用）募集代理店コード */
     ztyatukaikojincd                                           /* （中継用）扱者個人コード */
) ;
