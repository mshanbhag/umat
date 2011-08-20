<CplProject xmlns="http://www.sybase.com/cpl/2004/04/" Name="IndexesCalculation">
 <LoadModule Name="IndexesCalculation" ExternalName="modules/IndexesCalculation.ccl">
  <InputValues>
   <InputValue Name="StreamTrades" Value=""/>
   <InputValue Name="StreamRsiInitData" Value=""/>
  </InputValues>
  <OutputValues>
   <OutputValue Name="StreamRsi" Value=""/>
   <OutputValue Name="StreamCci" Value=""/>
   <OutputValue Name="StreamCompressedTradesByTick" Value=""/>
   <OutputValue Name="StreamCompressedTrades" Value=""/>
   <OutputValue Name="StreamVwap" Value=""/>
  </OutputValues>
 </LoadModule>
</CplProject>
