import { Component, OnInit } from '@angular/core';
import { UrlService } from 'src/app/service/url.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  url : string = "";
  originalUrl :string = "";
  isUrlGenerated : boolean = false;
  isErrorGenerated : boolean = false;
  shortUrl : string ="";
  constructor(private urlService : UrlService) { }

  ngOnInit(): void {
    this.isUrlGenerated = false;
  }
  generateShortUrl() {
    console.log(this.url)
    // this.urlService.getUrl(this.url).subscribe(result =>{

    // })
    this.urlService.getShortUrl(this.url).subscribe(res=>{
      if(res == null) {
        this.isErrorGenerated = true; 
      } else {
        this.isUrlGenerated = true;
        this.isErrorGenerated = false;
        this.shortUrl = res.shorturl;
        this.originalUrl = res.originalurl;
      }
    }, err=>{
      this.isUrlGenerated = false;
      this.isErrorGenerated = true;
    })
  }

}
