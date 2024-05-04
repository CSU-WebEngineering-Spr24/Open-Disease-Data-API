import ChartSection from "./ChartSection";
import TableSection from "./TableSection";
import TileSection from "./TileSection";

export function Dashboard({ globalData, stateData, countryData, continentData }) {

    return (
        <>
            <TileSection globalData={globalData} />
      <TableSection countryData={countryData} />
      <ChartSection
        globalData={globalData}
        stateData={stateData}
        continentData={continentData}
        countryData={countryData}
      />
        </>
    );
}