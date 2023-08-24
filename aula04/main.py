import requests
import json

url = "http://www.omdbapi.com/"
api_key = "a59ea74c"

params = {
    "apikey": api_key,
    "t": "Titanic"
}

try:
    response = requests.get(url, params=params)

    if response.status_code == 200:
        data = response.json()

        filme = {
            "Title": data["Title"],
            "Year": data["Year"],
            "Runtime": data["Runtime"],
            "Genre": data["Genre"],
            "Director": data["Director"],
            "imdbRating": data["imdbRating"]
        }

        with open("filme.json", "w") as json_file:
            json.dump(filme, json_file, indent=4, ensure_ascii=False)

        print(data)

    else:
        print("Erro na requisição:", response.status_code)
except requests.exceptions.RequestException as e:
    print("Erro na requisição:", e)