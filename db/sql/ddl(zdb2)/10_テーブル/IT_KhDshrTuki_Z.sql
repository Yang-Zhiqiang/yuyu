CREATE TABLE IT_KhDshrTuki_Z (
     dshrtoukeisikibetukey                              VARCHAR     (20)                                                      NOT NULL  ,  /* Ｄ支払統計識別キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     renno                                              DECIMAL     (2)                                                                 ,  /* 連番 */
     henkousikibetukey                                  VARCHAR     (18)                                                                ,  /* 変更識別キー */
     syoriYmd                                           VARCHAR     (8)                                                                 ,  /* 処理年月日 */
     syorikbn                                           VARCHAR     (2)                                                                 ,  /* 処理区分 */
     hrkkeiro                                           VARCHAR     (2)                                                                 ,  /* 払込経路 */
     syouhncd                                           VARCHAR     (4)                                                                 ,  /* 商品コード */
     syouhnsdno                                         DECIMAL     (2)                                                                 ,  /* 商品世代番号 */
     kykjyoutai                                         VARCHAR     (2)                                                                 ,  /* 契約状態 */
     syoumetujiyuu                                      VARCHAR     (2)                                                                 ,  /* 消滅事由 */
     kykymd                                             VARCHAR     (8)                                                                 ,  /* 契約日 */
     yendthnkymd                                        VARCHAR     (8)                                                                 ,  /* 円建変更日 */
     kihons                                             DECIMAL     (13)                                                                ,  /* 基本Ｓ */
     kihons$                                            VARCHAR     (10)                                                                ,  /* 基本Ｓ(通貨型) */
     yoteiriritu                                        DECIMAL     (5,4)                                                               ,  /* 予定利率 */
     denymd                                             VARCHAR     (8)                                                                 ,  /* 伝票日付 */
     siharaid                                           DECIMAL     (13)                                                                ,  /* 支払Ｄ */
     siharaid$                                          VARCHAR     (10)                                                                ,  /* 支払Ｄ(通貨型) */
     calckijyunymd                                      VARCHAR     (8)                                                                 ,  /* 計算基準日 */
     syoriymd2                                          VARCHAR     (8)                                                                 ,  /* 処理年月日２ */
     jkipjytym                                          VARCHAR     (6)                                                                 ,  /* 次回Ｐ充当年月 */
     kinoubetukijyunymd                                 VARCHAR     (8)                                                                 ,  /* 機能別基準日 */
     gengkwari                                          DECIMAL     (11,10)                                                             ,  /* 減額割合 */
     itibushrgk                                         DECIMAL     (13)                                                                ,  /* 一部支払金額 */
     itibushrgk$                                        VARCHAR     (10)                                                                ,  /* 一部支払金額(通貨型) */
     haitoushrkin                                       DECIMAL     (13)                                                                ,  /* 配当支払金 */
     haitoushrkin$                                      VARCHAR     (10)                                                                ,  /* 配当支払金(通貨型) */
     kariwariatedruigk                                  DECIMAL     (13)                                                                ,  /* 仮割当Ｄ累計額 */
     kariwariatedruigk$                                 VARCHAR     (10)                                                                ,  /* 仮割当Ｄ累計額(通貨型) */
     kariwariatedgngkkngk                               DECIMAL     (13)                                                                ,  /* 仮割当Ｄ減額金額 */
     kariwariatedgngkkngk$                              VARCHAR     (10)                                                                ,  /* 仮割当Ｄ減額金額(通貨型) */
     kariwariatedshrgk                                  DECIMAL     (13)                                                                ,  /* 仮割当Ｄ支払額 */
     kariwariatedshrgk$                                 VARCHAR     (10)                                                                ,  /* 仮割当Ｄ支払額(通貨型) */
     dkeisanhaitoukin                                   DECIMAL     (13)                                                                ,  /* 配当金計算配当金 */
     dkeisanhaitoukin$                                  VARCHAR     (10)                                                                ,  /* 配当金計算配当金(通貨型) */
     dkeisannaiteikakuteikbn                            VARCHAR     (1)                                                                 ,  /* 配当金計算内定確定区分 */
     haitounendo                                        VARCHAR     (4)                                                                 ,  /* 配当年度 */
     haitoushrkingk                                     DECIMAL     (13)                                                                ,  /* 配当支払金額 */
     haitoushrkingk$                                    VARCHAR     (10)                                                                ,  /* 配当支払金額(通貨型) */
     kariwariatedganrikindshr                           DECIMAL     (13)                                                                ,  /* 仮割当Ｄ元利金（配当支払金用） */
     kariwariatedganrikindshr$                          VARCHAR     (10)                                                                ,  /* 仮割当Ｄ元利金（配当支払金用）(通貨型) */
     tumitated                                          DECIMAL     (13)                                                                ,  /* 積立Ｄ */
     tumitated$                                         VARCHAR     (10)                                                                ,  /* 積立Ｄ(通貨型) */
     tumitatedmodosimae                                 DECIMAL     (13)                                                                ,  /* 積立Ｄ（割戻し前） */
     tumitatedmodosimae$                                VARCHAR     (10)                                                                ,  /* 積立Ｄ（割戻し前）(通貨型) */
     tumitatedmodosigo                                  DECIMAL     (13)                                                                ,  /* 積立Ｄ（割戻し後） */
     tumitatedmodosigo$                                 VARCHAR     (10)                                                                ,  /* 積立Ｄ（割戻し後）(通貨型) */
     tkbthaitou                                         DECIMAL     (13)                                                                ,  /* 特別配当 */
     tkbthaitou$                                        VARCHAR     (10)                                                                ,  /* 特別配当(通貨型) */
     haitounendo2                                       VARCHAR     (4)                                                                 ,  /* 配当年度２ */
     haitoukinskskbn                                    VARCHAR     (2)                                                                 ,  /* 配当金作成区分 */
     haitoumeisaikbn                                    VARCHAR     (2)                                                                 ,  /* 配当明細区分 */
     fstkariwariatednendo                               VARCHAR     (4)                                                                 ,  /* 初回仮割当Ｄ年度 */
     tounendod                                          DECIMAL     (13)                                                                ,  /* 当年度Ｄ */
     tounendod$                                         VARCHAR     (10)                                                                ,  /* 当年度Ｄ(通貨型) */
     naiteikakuteikbn                                   VARCHAR     (1)                                                                 ,  /* 内定確定区分 */
     kariwariatedshrymd                                 VARCHAR     (8)                                                                 ,  /* 仮割当Ｄ支払年月日 */
     kariwariatedruigk2                                 DECIMAL     (13)                                                                ,  /* 仮割当Ｄ累計額２ */
     kariwariatedruigk2$                                VARCHAR     (10)                                                                ,  /* 仮割当Ｄ累計額２(通貨型) */
     kariwariatedgngkkngk2                              DECIMAL     (13)                                                                ,  /* 仮割当Ｄ減額金額２ */
     kariwariatedgngkkngk2$                             VARCHAR     (10)                                                                ,  /* 仮割当Ｄ減額金額２(通貨型) */
     kariwariatedshrgk2                                 DECIMAL     (13)                                                                ,  /* 仮割当Ｄ支払額２ */
     kariwariatedshrgk2$                                VARCHAR     (10)                                                                ,  /* 仮割当Ｄ支払額２(通貨型) */
     tumitatedtumitateymd                               VARCHAR     (8)                                                                 ,  /* 積立Ｄ積立年月日 */
     tumitatedskskbn                                    VARCHAR     (2)                                                                 ,  /* 積立Ｄ作成区分 */
     tumitated2                                         DECIMAL     (13)                                                                ,  /* 積立Ｄ２ */
     tumitated2$                                        VARCHAR     (10)                                                                ,  /* 積立Ｄ２(通貨型) */
     tumitatedshrkrkymd                                 VARCHAR     (8)                                                                 ,  /* 積立Ｄ支払効力日 */
     naiteikakuteikbn2                                  VARCHAR     (1)                                                                 ,  /* 内定確定区分２ */
     haitouganrikincalckari                             DECIMAL     (13)                                                                ,  /* 配当元利金計算（仮割当Ｄ元利金） */
     haitouganrikincalckari$                            VARCHAR     (10)                                                                ,  /* 配当元利金計算（仮割当Ｄ元利金）(通貨型) */
     kariwariatedriritu1                                DECIMAL     (5,4)                                                               ,  /* 仮割当Ｄ利率１ */
     kariwariatedriritu2                                DECIMAL     (5,4)                                                               ,  /* 仮割当Ｄ利率２ */
     haitouganrikincalctumi                             DECIMAL     (13)                                                                ,  /* 配当元利金計算（積立Ｄ元利金） */
     haitouganrikincalctumi$                            VARCHAR     (10)                                                                ,  /* 配当元利金計算（積立Ｄ元利金）(通貨型) */
     tumitatedriritu1                                   DECIMAL     (5,4)                                                               ,  /* 積立Ｄ利率１ */
     tumitatedriritu2                                   DECIMAL     (5,4)                                                               ,  /* 積立Ｄ利率２ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IT_KhDshrTuki_Z ADD CONSTRAINT PK_KhDshrTuki PRIMARY KEY (
     dshrtoukeisikibetukey                                    , /* Ｄ支払統計識別キー */
     syono                                                      /* 証券番号 */
) ;
