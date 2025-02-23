async function fetchExoplanets() {
    try {
        let number_of_moons1 = 0;
        let number_of_moons2 = 10000;
        let binary_star = 1;
        let orbit_radius1 = 0;
        let orbit_radius2 = 100000;
        let planet_radius1 = 0;
        let planet_radius2 = 10000;
        let star_temp1 = 0;
        let star_temp2 = 100000;
        let star_radius1 = 0;
        let star_radius2 = 100;
        let distance_to_planet1 = 0;
        let distance_to_planet2 = 100;

        let url = `https://exoplanetarchive.ipac.caltech.edu/TAP/sync?query=select+pl_name,hd_name,sy_snum,sy_pnum,sy_mnum,cb_flag,disc_year,pl_orbper,pl_orbsmax,pl_rade,pl_masse,pl_dens,pl_orbeccen,pl_eqt,pl_orbincl,st_spectype,st_teff,st_rad,st_mass,st_lum,st_logg,st_age,st_dens,st_vsin,sy_dist+from+pscomppars+where+sy_mnum+between+${number_of_moons1}+and+${number_of_moons2}+and+cb_flag=${binary_star}+and+pl_orbsmax+between+${orbit_radius1}+and+${orbit_radius2}+and+pl_rade+between+${planet_radius1}+and+${planet_radius2}+and+st_teff+between+${star_temp1}+and+${star_temp2}+and+st_rad+between+${star_radius1}+and+${star_radius2}+and+sy_dist+between+${distance_to_planet1}+and+${distance_to_planet2}&format=json`;

        let response = await fetch(url);
        if (!response.ok) {
            console.error(`HTTP Error: ${response.status}`);
            return;
        }

        let data = await response.json();
        data = data.slice(0,10);
        data.forEach(obj => {
            let planetName = obj.pl_name || "Unknown";
            let hostStar = obj.hd_name || "Unknown";
            let numStars = obj.sy_snum || -1;
            let numPlanets = obj.sy_pnum || -1;
            let numMoons = obj.sy_mnum || -1;
            let flag = obj.cd_flag || -1;
            let discoveryYear = obj.disc_year || -1;
            let orbitPeriod = obj.pl_orbper || -1;
            let orbitRadius = obj.pl_orbsmax || -1;
            let planetRadius = obj.pl_rade || -1;
            let planetMass = obj.pl_masse || -1;
            let planetDensity = obj.pl_dens || -1;
            let eccentricity = obj.pl_orbeccen || -1;
            let inclination = obj.pl_orbeccen || -1;
            let starCLass = obj.st_spectype || -1;
            let starTemperature = obj.st_teff || -1;
            let starRadius = obj.st_rad || -1;
            let starMass = obj.st_mass || -1;
            let starLum = obj.st_lum || -1;
            let starGravity = obj.st_logg || -1;
            let starAge = obj.st_age || -1;
            let starDensity = obj.st_dens || -1;
            let distanceToPlanet = obj.sy_dist || -1;

            console.log(`Planet: ${planetName} | Host Star: ${hostStar} | NumStars: ${numStars} | NumPlanets: ${numPlanets} | NumMoons: ${numMoons} | BinarySystem: ${flag} | DiscoveryYear: ${discoveryYear} | Orbit Period: ${orbitPeriod} | Orbit Radius: ${orbitRadius} AU | Planet Radius: ${planetRadius} Earth radii | Planet Mass: ${planetMass} | Planet Density: ${planetDensity} | Eccentricity: ${eccentricity} | Inclination: ${inclination} | Star class: ${starCLass} | Star Temp: ${starTemperature} K | Star Radius: ${starRadius} | Star Mass: ${starMass} | Star Luminosity: ${starLum} | Star Gravity: ${starGravity} | Star Age: ${starAge} | Star Density: ${starDensity} | Distance: ${distanceToPlanet} LY`);
        });
    } catch (error) {
        console.error(error);
    }
}

fetchExoplanets();
