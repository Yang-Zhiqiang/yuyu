CREATE TABLE IT_BAK_KhDshrTuki (
     dshrtoukeisikibetukey                              VARCHAR     (20)                                                      NOT NULL  ,  /* Ｄ支払統計識別キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     trkssikibetukey                                    VARCHAR     (18)                                                      NOT NULL  ,  /* 取消識別キー */
     renno                                              NUMBER      (2)                                                                 ,  /* 連番 */
     henkousikibetukey                                  VARCHAR     (18)                                                                ,  /* 変更識別キー */
     syoriYmd                                           VARCHAR     (8)                                                                 ,  /* 処理年月日 */
     syorikbn                                           VARCHAR     (2)                                                                 ,  /* 処理区分 */
     hrkkeiro                                           VARCHAR     (2)                                                                 ,  /* 払込経路 */
     syouhncd                                           VARCHAR     (4)                                                                 ,  /* 商品コード */
     syouhnsdno                                         NUMBER      (2)                                                                 ,  /* 商品世代番号 */
     kykjyoutai                                         VARCHAR     (2)                                                                 ,  /* 契約状態 */
     syoumetujiyuu                                      VARCHAR     (2)                                                                 ,  /* 消滅事由 */
     kykymd                                             VARCHAR     (8)                                                                 ,  /* 契約日 */
     yendthnkymd                                        VARCHAR     (8)                                                                 ,  /* 円建変更日 */
     kihons                                             NUMBER      (13)                                                                ,  /* 基本Ｓ */
     kihons$                                            VARCHAR     (10)                                                                ,  /* 基本Ｓ(通貨型) */
     yoteiriritu                                        NUMBER      (5,4)                                                               ,  /* 予定利率 */
     denymd                                             VARCHAR     (8)                                                                 ,  /* 伝票日付 */
     siharaid                                           NUMBER      (13)                                                                ,  /* 支払Ｄ */
     siharaid$                                          VARCHAR     (10)                                                                ,  /* 支払Ｄ(通貨型) */
     calckijyunymd                                      VARCHAR     (8)                                                                 ,  /* 計算基準日 */
     syoriymd2                                          VARCHAR     (8)                                                                 ,  /* 処理年月日２ */
     jkipjytym                                          VARCHAR     (6)                                                                 ,  /* 次回Ｐ充当年月 */
     kinoubetukijyunymd                                 VARCHAR     (8)                                                                 ,  /* 機能別基準日 */
     gengkwari                                          NUMBER      (11,10)                                                             ,  /* 減額割合 */
     itibushrgk                                         NUMBER      (13)                                                                ,  /* 一部支払金額 */
     itibushrgk$                                        VARCHAR     (10)                                                                ,  /* 一部支払金額(通貨型) */
     haitoushrkin                                       NUMBER      (13)                                                                ,  /* 配当支払金 */
     haitoushrkin$                                      VARCHAR     (10)                                                                ,  /* 配当支払金(通貨型) */
     kariwariatedruigk                                  NUMBER      (13)                                                                ,  /* 仮割当Ｄ累計額 */
     kariwariatedruigk$                                 VARCHAR     (10)                                                                ,  /* 仮割当Ｄ累計額(通貨型) */
     kariwariatedgngkkngk                               NUMBER      (13)                                                                ,  /* 仮割当Ｄ減額金額 */
     kariwariatedgngkkngk$                              VARCHAR     (10)                                                                ,  /* 仮割当Ｄ減額金額(通貨型) */
     kariwariatedshrgk                                  NUMBER      (13)                                                                ,  /* 仮割当Ｄ支払額 */
     kariwariatedshrgk$                                 VARCHAR     (10)                                                                ,  /* 仮割当Ｄ支払額(通貨型) */
     dkeisanhaitoukin                                   NUMBER      (13)                                                                ,  /* 配当金計算配当金 */
     dkeisanhaitoukin$                                  VARCHAR     (10)                                                                ,  /* 配当金計算配当金(通貨型) */
     dkeisannaiteikakuteikbn                            VARCHAR     (1)                                                                 ,  /* 配当金計算内定確定区分 */
     haitounendo                                        VARCHAR     (4)                                                                 ,  /* 配当年度 */
     haitoushrkingk                                     NUMBER      (13)                                                                ,  /* 配当支払金額 */
     haitoushrkingk$                                    VARCHAR     (10)                                                                ,  /* 配当支払金額(通貨型) */
     kariwariatedganrikindshr                           NUMBER      (13)                                                                ,  /* 仮割当Ｄ元利金（配当支払金用） */
     kariwariatedganrikindshr$                          VARCHAR     (10)                                                                ,  /* 仮割当Ｄ元利金（配当支払金用）(通貨型) */
     tumitated                                          NUMBER      (13)                                                                ,  /* 積立Ｄ */
     tumitated$                                         VARCHAR     (10)                                                                ,  /* 積立Ｄ(通貨型) */
     tumitatedmodosimae                                 NUMBER      (13)                                                                ,  /* 積立Ｄ（割戻し前） */
     tumitatedmodosimae$                                VARCHAR     (10)                                                                ,  /* 積立Ｄ（割戻し前）(通貨型) */
     tumitatedmodosigo                                  NUMBER      (13)                                                                ,  /* 積立Ｄ（割戻し後） */
     tumitatedmodosigo$                                 VARCHAR     (10)                                                                ,  /* 積立Ｄ（割戻し後）(通貨型) */
     tkbthaitou                                         NUMBER      (13)                                                                ,  /* 特別配当 */
     tkbthaitou$                                        VARCHAR     (10)                                                                ,  /* 特別配当(通貨型) */
     haitounendo2                                       VARCHAR     (4)                                                                 ,  /* 配当年度２ */
     haitoukinskskbn                                    VARCHAR     (2)                                                                 ,  /* 配当金作成区分 */
     haitoumeisaikbn                                    VARCHAR     (2)                                                                 ,  /* 配当明細区分 */
     fstkariwariatednendo                               VARCHAR     (4)                                                                 ,  /* 初回仮割当Ｄ年度 */
     tounendod                                          NUMBER      (13)                                                                ,  /* 当年度Ｄ */
     tounendod$                                         VARCHAR     (10)                                                                ,  /* 当年度Ｄ(通貨型) */
     naiteikakuteikbn                                   VARCHAR     (1)                                                                 ,  /* 内定確定区分 */
     kariwariatedshrymd                                 VARCHAR     (8)                                                                 ,  /* 仮割当Ｄ支払年月日 */
     kariwariatedruigk2                                 NUMBER      (13)                                                                ,  /* 仮割当Ｄ累計額２ */
     kariwariatedruigk2$                                VARCHAR     (10)                                                                ,  /* 仮割当Ｄ累計額２(通貨型) */
     kariwariatedgngkkngk2                              NUMBER      (13)                                                                ,  /* 仮割当Ｄ減額金額２ */
     kariwariatedgngkkngk2$                             VARCHAR     (10)                                                                ,  /* 仮割当Ｄ減額金額２(通貨型) */
     kariwariatedshrgk2                                 NUMBER      (13)                                                                ,  /* 仮割当Ｄ支払額２ */
     kariwariatedshrgk2$                                VARCHAR     (10)                                                                ,  /* 仮割当Ｄ支払額２(通貨型) */
     tumitatedtumitateymd                               VARCHAR     (8)                                                                 ,  /* 積立Ｄ積立年月日 */
     tumitatedskskbn                                    VARCHAR     (2)                                                                 ,  /* 積立Ｄ作成区分 */
     tumitated2                                         NUMBER      (13)                                                                ,  /* 積立Ｄ２ */
     tumitated2$                                        VARCHAR     (10)                                                                ,  /* 積立Ｄ２(通貨型) */
     tumitatedshrkrkymd                                 VARCHAR     (8)                                                                 ,  /* 積立Ｄ支払効力日 */
     naiteikakuteikbn2                                  VARCHAR     (1)                                                                 ,  /* 内定確定区分２ */
     haitouganrikincalckari                             NUMBER      (13)                                                                ,  /* 配当元利金計算（仮割当Ｄ元利金） */
     haitouganrikincalckari$                            VARCHAR     (10)                                                                ,  /* 配当元利金計算（仮割当Ｄ元利金）(通貨型) */
     kariwariatedriritu1                                NUMBER      (5,4)                                                               ,  /* 仮割当Ｄ利率１ */
     kariwariatedriritu2                                NUMBER      (5,4)                                                               ,  /* 仮割当Ｄ利率２ */
     haitouganrikincalctumi                             NUMBER      (13)                                                                ,  /* 配当元利金計算（積立Ｄ元利金） */
     haitouganrikincalctumi$                            VARCHAR     (10)                                                                ,  /* 配当元利金計算（積立Ｄ元利金）(通貨型) */
     tumitatedriritu1                                   NUMBER      (5,4)                                                               ,  /* 積立Ｄ利率１ */
     tumitatedriritu2                                   NUMBER      (5,4)                                                               ,  /* 積立Ｄ利率２ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IT_BAK_KhDshrTuki ADD CONSTRAINT PK_BAK_KhDshrTuki PRIMARY KEY (
     dshrtoukeisikibetukey                                    , /* Ｄ支払統計識別キー */
     syono                                                    , /* 証券番号 */
     trkssikibetukey                                            /* 取消識別キー */
) ;
